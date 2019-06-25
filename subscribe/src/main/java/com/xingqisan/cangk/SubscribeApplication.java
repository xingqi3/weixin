package com.xingqisan.cangk;


import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xingqisan.commons.domain.InMessage;
import com.xingqisan.commons.domain.event.EventInMessage;
import com.xingqisan.commons.processors.EventMessageProcessor;
import com.xingqisan.commons.service.JsonRedisSerializer;

@SpringBootApplication
@ComponentScan("com.xingqisan")
@EnableJpaRepositories("com.xingqisan")
@EntityScan("com.xingqisan")
public class SubscribeApplication implements //
		CommandLineRunner, //
		DisposableBean, //
		ApplicationContextAware {
	private ApplicationContext ctx;// Spring容器

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}

	private final Object stopMonitor = new Object();

	@Override
	public void run(String... args) throws Exception {
		new Thread(() -> {
			synchronized (stopMonitor) {
				try {
					// 等待停止通知
					stopMonitor.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void destroy() throws Exception {
		// 发送停止通知
		synchronized (stopMonitor) {
			stopMonitor.notify();
		}
	}

	@Bean
	public RedisTemplate<String, InMessage> inMessageTemplate(//
			@Autowired RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, InMessage> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);

	

		template.setValueSerializer(new JsonRedisSerializer());

		return template;
	}

	@Bean
	public MessageListenerAdapter messageListener(@Autowired RedisTemplate<String, InMessage> inMessageTemplate) {
		MessageListenerAdapter adapter = new MessageListenerAdapter();
		// 共用模板里面的序列化程序
		adapter.setSerializer(inMessageTemplate.getValueSerializer());

		// 设置消息处理程序的代理对象
		adapter.setDelegate(this);
		// 设置代理对象里面哪个方法用于处理消息，设置方法名
		adapter.setDefaultListenerMethod("handle");

		return adapter;
	}

	@Bean
	public RedisMessageListenerContainer messageListenerContainer(//
			@Autowired RedisConnectionFactory redisConnectionFactory, //
			@Autowired MessageListener l) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(redisConnectionFactory);

	
		List<Topic> topics = new ArrayList<>();

	
		topics.add(new ChannelTopic("sc_event"));
		container.addMessageListener(l, topics);

		return container;
	}

	private static final Logger LOG = LoggerFactory.getLogger(SubscribeApplication.class);

	public void handle(EventInMessage msg) {
		
		String id = msg.getEvent().toLowerCase() + "MessageProcessor";
	
		try {
			EventMessageProcessor mp = (EventMessageProcessor) ctx.getBean(id);
			// 4.强制类型转换以后，调用onMessage方法
			if (mp != null) {
				mp.onMessage(msg);
			} else {
				LOG.warn("Bean的ID {} 无法调用对应的消息处理器: {} 对应的Bean不存在", id, id);
			}
		} catch (Exception e) {
			LOG.warn("Bean的ID {} 无法调用对应的消息处理器: {}", id, e.getMessage());
			LOG.trace(e.getMessage(), e);
		}
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SubscribeApplication.class, args);

	}

}
