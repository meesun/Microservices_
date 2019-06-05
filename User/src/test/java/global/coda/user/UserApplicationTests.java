package global.coda.user;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import global.coda.user.dto.OrderDTO;
import global.coda.user.dto.UserDTO;
import global.coda.user.exception.types.UserNotFoundException;
import global.coda.user.exception.types.UserServiceException;
import global.coda.user.message.publisher.MQPublisher;
import global.coda.user.model.User;
import global.coda.user.repository.UserRepository;
import global.coda.user.service.impl.UserServiceImpl;
import global.coda.user.service.proxy.OrderServiceProxy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private OrderServiceProxy orderServiceProxy;
	
	@Autowired
	private MQPublisher publisher;
	
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
		userService.insertUser(user);
	}
	
	@Test
	public void testGetUserById() throws UserServiceException, UserNotFoundException 
	{
		
		//Mockito.mock(UserRepository.class);
		//Mockito.mock(OrderServiceProxy.class);
		
		OrderDTO order = new OrderDTO();
		order.setOrderId(100);
		order.setOrderTotal(100);
		order.setStatus("A");
		order.setUserId(200);
		order.setDelete(true);
		List<OrderDTO> orderList = new ArrayList<>();
		orderList.add(order);
		
		User user = new User();
		user.setUserId(100);
		user.setUserPhoneNo(8508863351l);
		user.setUserName("MeeSun");
		user.setUserAddress("Chennai");
		user.setActive(true);
		Optional<User> userOp = Optional.of(user);
		
		
		when(orderServiceProxy.getOrderbyUserId(Mockito.anyLong())).thenReturn(orderList);
		
		when(userRepository.findById(Mockito.anyLong())).thenReturn(userOp);
		assertNotNull(userService.getUserInfoById(100));
	}
	
	

}
