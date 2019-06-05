package global.coda.user.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import global.coda.user.exception.types.UserBusinessException;
import global.coda.user.exception.types.UserSystemException;

@ControllerAdvice
public class UserGlobalExceptionHandler {

	@ExceptionHandler({ UserSystemException.class })
	@ResponseBody
	public String handleSystemExceptions(UserSystemException e) {
		return e.getErrCode() + " : " + e.getErrMsg() + ". Cause : " + e.getCause().getMessage();
	}

	@ExceptionHandler({ UserBusinessException.class })
	@ResponseBody
	public String handleBusinessExceptions(UserBusinessException e) {
		return e.getErrCode() + " : " + e.getErrMsg();
	}

}
