package global.coda.user.exception.handler;

import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class FeignExceptionhandler implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400 && response.status() <= 499) {
            log.error("Bad Request");
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }

}