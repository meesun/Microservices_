package global.coda.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import global.coda.user.exception.handler.FeignExceptionhandler;

@SpringBootApplication
@EnableFeignClients
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	
	@Bean
	public FeignExceptionhandler myErrorDecoder() {
		return new FeignExceptionhandler();
	}

}
