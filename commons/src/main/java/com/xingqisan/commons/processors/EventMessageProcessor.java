package com.xingqisan.commons.processors;

import com.xingqisan.commons.domain.event.EventInMessage;

public interface EventMessageProcessor {

	public void onMessage(EventInMessage msg);
}
