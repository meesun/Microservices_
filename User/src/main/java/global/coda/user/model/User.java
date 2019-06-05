package global.coda.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
	
	@Id
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_ADDRESS")
	private String userAddress;
	
	@Column(name = "USER_PHONE_NO")
	private long userPhoneNo;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;

}
