package global.coda.user.message.publisher.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import global.coda.user.message.publisher.RabbitMQPublisher;

@EnableBinding(Source.class)
public class RabbitMQPublisherImpl implements RabbitMQPublisher {
	@Autowired
    private Source source;
	
	@Override
	public String publishMessage(Object message) {
		source.output().send(MessageBuilder.withPayload(message).build());
		return PUBLISH_SUCCESS;
	}

}
