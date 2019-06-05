package global.coda.user.service;

import java.util.List;

import global.coda.user.dto.UserDTO;
import global.coda.user.exception.types.UserNotFoundException;
import global.coda.user.exception.types.UserServiceException;

public interface UserService {

	List<UserDTO> getAllUsers();

	UserDTO getUserInfoById(long id) throws UserServiceException, UserNotFoundException;

	void insertUser(UserDTO user) throws UserServiceException;

	void deleteUser(long id) throws UserServiceException;

}
