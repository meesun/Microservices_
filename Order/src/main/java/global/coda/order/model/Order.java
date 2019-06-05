package global.coda.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="orders")
@Data
public class Order {
	
	@Id
	@Column(name="ORDER_ID")
	private long orderId;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="ORDER_TOTAL")
	private double orderTotal;
	
	@Column(name="ORDER_STATUS")
	private String status;
	
	@Column(name="IS_DELETE")
	private boolean isDelete;
}
