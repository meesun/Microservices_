package global.coda.order.exception.types;

public class OrderBusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6536472186445373705L;
	private String errCode;
	private String errMsg;
	
	public OrderBusinessException(String errCode, String errMsg)
	{
		super(errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg ;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

}
