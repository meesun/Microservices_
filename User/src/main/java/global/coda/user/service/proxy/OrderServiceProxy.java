package global.coda.user.service.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import global.coda.user.dto.OrderDTO;

@FeignClient(name="OrderServiceProxyIntf", url="localhost:3000/order")
public interface OrderServiceProxy {
	
	@GetMapping("/user/{userId}")
	public List<OrderDTO> getOrderbyUserId(@PathVariable("userId")long userId);

}
