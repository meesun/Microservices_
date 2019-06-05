package global.coda.user.exception.types;

public class UserSystemException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5271344859726734562L;
	private String errCode;
	private String errMsg;
	private Exception cause;
	
	public UserSystemException(String errCode, String errMsg, Exception e)
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
