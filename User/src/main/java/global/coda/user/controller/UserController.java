package global.coda.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import global.coda.user.dto.UserDTO;
import global.coda.user.exception.types.UserNotFoundException;
import global.coda.user.exception.types.UserServiceException;
import global.coda.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String helloWorld() {
		return "User Services";
	}

	@GetMapping("/all")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();

	}

	@GetMapping("/{id}")
	public UserDTO getUserInfoById(@PathVariable("id") long id) throws UserServiceException, UserNotFoundException {
		return userService.getUserInfoById(id);

	}

	@PutMapping("/")
	public String insertUser(@RequestBody UserDTO userDTO) throws UserServiceException {
		userService.insertUser(userDTO);
		return "Inserted Successfully!";
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") long id) throws UserServiceException {
		userService.deleteUser(id);
		return "Deleted Successfully!";
	}

}
