package global.coda.user.exception.types;

public class UserServiceException extends UserSystemException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4253839816989422227L;
	
	public UserServiceException(String errCode, String errMsg, Exception e)
	{
		super(errCode, errMsg, e);
	}


}
