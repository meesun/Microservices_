package global.coda.user.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import global.coda.user.dto.UserDTO;
import global.coda.user.model.User;

public class MapperUtil {
	
	private static ModelMapper mapper = new ModelMapper();

	public static UserDTO convertToUserDTO(User user) {
		return mapper.map(user, UserDTO.class);
	}

	public static User convertToUser(UserDTO userDTO) {
		return mapper.map(userDTO, User.class);
	}

}
