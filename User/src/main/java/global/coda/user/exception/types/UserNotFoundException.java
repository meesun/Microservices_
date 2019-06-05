package global.coda.user.exception.types;

public class UserNotFoundException extends UserBusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 196121064634848524L;

	public UserNotFoundException(String errCode, String errMsg) {
		super(errCode, errMsg);
	}

}
