package global.coda.order.exception.types;

public class OrderServiceException extends OrderSystemException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4253839816989422227L;
	
	public OrderServiceException(String errCode, String errMsg, Exception e)
	{
		super(errCode, errMsg, e);
	}


}
