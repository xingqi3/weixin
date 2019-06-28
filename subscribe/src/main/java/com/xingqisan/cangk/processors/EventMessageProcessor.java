package com.xingqisan.cangk.processors;

import com.xingqisan.commons.domain.event.EventInMessage;

public interface EventMessageProcessor {

	public void onMessage(EventInMessage msg);
}
