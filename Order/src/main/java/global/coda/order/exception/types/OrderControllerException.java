package global.coda.order.exception.types;

public class OrderControllerException extends OrderSystemException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6024868354009913573L;
	
	
	public OrderControllerException(String errCode, String errMsg, Exception e)
	{
		super(errCode, errMsg, e);
		
	}


}
