package global.coda.user.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6105902231151434939L;
	private long userId;
	private String userName;
	private String userAddress;
	private long userPhoneNo;
	private boolean active;
	private List<OrderDTO> orderDTO;
	
}
