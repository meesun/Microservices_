package global.coda.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import global.coda.order.dto.OrderDTO;
import global.coda.order.exception.types.OrderNotFoundException;
import global.coda.order.exception.types.OrderServiceException;
import global.coda.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/")
	public String init() {
		return "Order Services";
	}

	@GetMapping("/all")
	public List<OrderDTO> getAllOrders() throws OrderServiceException {
		return orderService.getAllOrders();
	}

	@GetMapping("/{orderId}")
	public OrderDTO getOrderById(@PathVariable("orderId") long orderId) throws OrderNotFoundException, OrderServiceException {
		return orderService.getOrderById(orderId);
	}

	@PutMapping("/")
	public String addOrder(@RequestBody OrderDTO orderDTO) throws OrderServiceException {
		orderService.insertOrder(orderDTO);
		return "Inserted successfully";
	}
	
	
	@GetMapping("/user/{userId}")
	public List<OrderDTO> getOrderbyUserId(@PathVariable("userId") long userId) throws OrderServiceException {
		return orderService.getOrdersByUserId(userId);
	}
	
}
