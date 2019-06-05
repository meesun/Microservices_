package global.coda.order.exception.types;

public class OrderNotFoundException extends OrderBusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 196121064634848524L;

	public OrderNotFoundException(String errCode, String errMsg) {
		super(errCode, errMsg);
	}

}
