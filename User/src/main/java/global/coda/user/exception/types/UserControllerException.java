package global.coda.user.exception.types;

public class UserControllerException extends UserSystemException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6024868354009913573L;
	
	
	public UserControllerException(String errCode, String errMsg, Exception e)
	{
		super(errCode, errMsg, e);
		
	}


}
