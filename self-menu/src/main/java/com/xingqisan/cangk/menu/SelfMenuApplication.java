package com.xingqisan.cangk.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.xingqisan.commons.config.EventListenerConfig;
import com.xingqisan.commons.domain.event.EventInMessage;

@SpringBootApplication
@EntityScan("com.xingqisan")
@ComponentScan("com.xingqisan")
public class SelfMenuApplication implements EventListenerConfig {

	public static void main(String[] args) {

		SpringApplication.run(SelfMenuApplication.class, args);
	}

	@Override
	public void handle(EventInMessage msg) {
	}
}
