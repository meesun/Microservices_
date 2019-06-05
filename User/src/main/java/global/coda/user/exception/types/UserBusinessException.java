package global.coda.user.exception.types;

public class UserBusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6536472186445373705L;
	private String errCode;
	private String errMsg;
	
	public UserBusinessException(String errCode, String errMsg)
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
