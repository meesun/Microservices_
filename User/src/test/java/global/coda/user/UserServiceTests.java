package global.coda.user;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import global.coda.user.dto.OrderDTO;
import global.coda.user.dto.UserDTO;
import global.coda.user.exception.types.UserNotFoundException;
import global.coda.user.exception.types.UserServiceException;
import global.coda.user.message.publisher.MQPublisher;
import global.coda.user.repository.UserRepository;
import global.coda.user.service.impl.UserServiceImpl;
import global.coda.user.service.proxy.OrderServiceProxy;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Autowired
	private UserServiceImpl userService1;
	
	@Mock
	private OrderServiceProxy orderServiceProxy;
	
	@Mock
	private MQPublisher publisher;
	
	@Spy
	private UserRepository userRepository;
	
	
	@Test(expected = Test.None.class)
	public void testDeactivateUser() throws UserServiceException, UserNotFoundException {
		
		OrderDTO order = new OrderDTO();
		order.setOrderId(100);
		order.setOrderTotal(100);
		order.setStatus("A");
		order.setUserId(200);
		order.setDelete(true);
		List<OrderDTO> orderList = new ArrayList<>();
		orderList.add(order);
		when(orderServiceProxy.getOrderbyUserId(Mockito.anyLong())).thenReturn(orderList);
		
		
		when(publisher.publishMessage(Mockito.anyString())).thenReturn("");
		userService.deleteUser(100);
		
		
	}
	
	
	
	@Before
	public void initDB() throws UserServiceException
	{
		MockitoAnnotations.initMocks(this);
		
		UserDTO user = new UserDTO();
		user.setUserId(100);
		user.setUserPhoneNo(8508863351l);
		user.setUserName("MeeSun");
		user.setUserAddress("Chennai");
		user.setActive(true);
		userService1.insertUser(user);
	}
}
