package global.coda.order.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class  OrderDTO implements Serializable{

	private static final long serialVersionUID = 6771433707229904053L;
	private long orderId;
	private long userId;
	private double orderTotal;
	private String status;
	private boolean isDelete;
	
}
