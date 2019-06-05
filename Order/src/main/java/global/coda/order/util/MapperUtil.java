package global.coda.order.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import global.coda.order.dto.OrderDTO;
import global.coda.order.model.Order;
@Component
public class MapperUtil {
	
	
	private ModelMapper modelMapper = new ModelMapper();

	public OrderDTO convertToOrderDTO(Order order) {
		return modelMapper.map(order, OrderDTO.class);
	}
	
	public Order convertToOrder(OrderDTO orderDTO) {
		return modelMapper.map(orderDTO, Order.class);
	}

}
