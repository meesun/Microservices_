package global.coda.order.exception.types;

public class OrderSystemException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5271344859726734562L;
	private String errCode;
	private String errMsg;
	private Exception cause;
	
	public OrderSystemException(String errCode, String errMsg, Exception e)
	{
		super(errMsg, e);
		this.errCode = errCode;
		this.errMsg = errMsg ;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public Exception getCause() {
		return cause;
	}

	public void setCause(Exception cause) {
		this.cause = cause;
	}
}
