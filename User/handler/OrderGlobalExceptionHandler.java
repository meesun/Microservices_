package global.coda.order.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import global.coda.order.exception.types.OrderBusinessException;
import global.coda.order.exception.types.OrderSystemException;

@ControllerAdvice
public class OrderGlobalExceptionHandler {

	@ExceptionHandler({ OrderSystemException.class })
	@ResponseBody
	public String handleSystemExceptions(OrderSystemException e) {
		return e.getErrCode() + " : " + e.getErrMsg() + ". Cause : " + e.getCause().getMessage();
	}

	@ExceptionHandler({ OrderBusinessException.class })
	@ResponseBody
	public String handleBusinessExceptions(OrderBusinessException e) {
		return e.getErrCode() + " : " + e.getErrMsg();
	}

}
