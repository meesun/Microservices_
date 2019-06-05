package global.coda.user.message.publisher;

public interface MQPublisher {
	String PUBLISH_SUCCESS="Published successfully";
	public String publishMessage(Object message);
}
