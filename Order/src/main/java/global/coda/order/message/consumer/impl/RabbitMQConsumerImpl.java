package global.coda.order.message.consumer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import global.coda.order.message.consumer.RabbitMQConsumer;
import global.coda.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(Sink.class)
public class RabbitMQConsumerImpl implements RabbitMQConsumer {

	@Autowired
	private OrderService orderService;

	@Override
	@StreamListener(target = Sink.INPUT)
	public void consumeMessage(Object message) {
		log.info("Message recieved : " + message);
		try {
			long userId = Long.parseLong(String.valueOf(message));
			orderService.deleteOrderByUserId(userId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

	}

}
