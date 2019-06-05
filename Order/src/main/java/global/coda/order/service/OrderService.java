package global.coda.order.service;

import java.util.List;

import global.coda.order.dto.OrderDTO;
import global.coda.order.exception.types.OrderNotFoundException;
import global.coda.order.exception.types.OrderServiceException;

public interface OrderService {

	List<OrderDTO> getAllOrders() throws OrderServiceException;

	OrderDTO getOrderById(long id) throws OrderNotFoundException, OrderServiceException;

	void insertOrder(OrderDTO orderDTO) throws OrderServiceException;

	List<OrderDTO> getOrdersByUserId(long userId) throws OrderServiceException;

	void deleteOrderByUserId(long userId) throws OrderServiceException;

}
