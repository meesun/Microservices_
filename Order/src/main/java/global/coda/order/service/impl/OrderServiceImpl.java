package global.coda.order.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import global.coda.order.dto.OrderDTO;
import global.coda.order.exception.types.OrderNotFoundException;
import global.coda.order.exception.types.OrderServiceException;
import global.coda.order.model.Order;
import global.coda.order.repository.OrderRepository;
import global.coda.order.service.OrderService;
import global.coda.order.util.MapperUtil;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MapperUtil mapperUtil;

	@Override
	public List<OrderDTO> getAllOrders() throws OrderServiceException {
		try {
			return orderRepository.findAll().stream().map(order -> mapperUtil.convertToOrderDTO(order))
					.collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new OrderServiceException("ERROR007", "Error occured while fetching all the orders", e);
		}
	}

	@Override
	public OrderDTO getOrderById(long id) throws OrderNotFoundException, OrderServiceException {
		OrderDTO orderDTO = null;
		Optional<Order> orderOp = null;
		try {
			orderOp = orderRepository.findByOrderIdAndIsDeleteFalse(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new OrderServiceException("ERROR001", "Error occured while fetching order by id " + id, e);
		}
		Order order = null;
		if (orderOp.isPresent()) {
			order = orderOp.get();
			orderDTO = mapperUtil.convertToOrderDTO(order);
		} else {
			String errMsg = "Order with id " + id + " not found.";
			log.error(errMsg);
			throw new OrderNotFoundException("ERROR002", errMsg);
		}

		return orderDTO;
	}

	@Override
	public void insertOrder(OrderDTO orderDTO) throws OrderServiceException {
		try {
			Order order = mapperUtil.convertToOrder(orderDTO);
			orderRepository.save(order);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new OrderServiceException("ERROR003", "Error occured while inserting order", e);
		}

	}

	@Override
	public List<OrderDTO> getOrdersByUserId(long userId) throws OrderServiceException {
		List<OrderDTO> orderDTOList = null;
		try {
			List<Order> orderList = orderRepository.findByUserId(userId);
			if (!ObjectUtils.isEmpty(orderList)) {
				orderDTOList = orderList.parallelStream().map(order -> mapperUtil.convertToOrderDTO(order))
						.collect(Collectors.toList());
			} else {
				String errMsg = "There are no order for user with id " + userId;
				log.error(errMsg);
				throw new OrderNotFoundException("ERROR004", "There are no order for user with id " + userId);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new OrderServiceException("ERROR005", "Error occured while fetching orders by user id " + userId, e);
		}
		return orderDTOList;
	}

	@Override
	@Transactional
	public void deleteOrderByUserId(long userId) throws OrderServiceException {
		try {
			orderRepository.deactivateOrderByUserId(userId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new OrderServiceException("ERROR006", "Error occured while deleting orders of user id " + userId, e);
		}
	}

}
