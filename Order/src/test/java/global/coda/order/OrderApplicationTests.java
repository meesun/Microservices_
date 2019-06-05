package global.coda.order;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import global.coda.order.exception.types.OrderNotFoundException;
import global.coda.order.exception.types.OrderServiceException;
import global.coda.order.model.Order;
import global.coda.order.repository.OrderRepository;
import global.coda.order.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OrderApplicationTests {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderService orderService;

	
	@Before
	public void initDB()
	{
		Order order = new Order();
		order.setOrderId(100);
		order.setOrderTotal(100);
		order.setStatus("A");
		order.setUserId(200);
		order.setDelete(false);
		orderRepository.save(order);
	}
	
	@Test
	public void testGetOrderById() throws OrderNotFoundException, OrderServiceException
	{
		assertNotNull(orderService.getOrderById(100));
		assertThatExceptionOfType(OrderNotFoundException.class).isThrownBy(()->orderService.getOrderById(1));
	}
	
	@Test
	public void testGetAllOrder() throws OrderNotFoundException, OrderServiceException
	{
		assertNotNull(orderService.getAllOrders());
	}
	
	@Test
	public void testDeleteOrderByUserId() throws OrderNotFoundException, OrderServiceException
	{
		orderService.deleteOrderByUserId(200);
		assertThatExceptionOfType(OrderNotFoundException.class).isThrownBy(()->orderService.getOrderById(100));
	}

}
