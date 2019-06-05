package global.coda.user.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import feign.FeignException;
import global.coda.user.dto.OrderDTO;
import global.coda.user.dto.UserDTO;
import global.coda.user.exception.types.UserNotFoundException;
import global.coda.user.exception.types.UserServiceException;
import global.coda.user.message.publisher.MQPublisher;
import global.coda.user.model.User;
import global.coda.user.repository.UserRepository;
import global.coda.user.service.UserService;
import global.coda.user.service.proxy.OrderServiceProxy;
import global.coda.user.util.MapperUtil;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderServiceProxy orderServiceProxy;

	@Autowired
	private MQPublisher publisher;

	@Override
	public List<UserDTO> getAllUsers() {

		return userRepository.findAll().stream().map(userDTO -> MapperUtil.convertToUserDTO(userDTO))
				.collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserInfoById(long id) throws UserServiceException, UserNotFoundException {
		UserDTO userDTO = null;
		Optional<User> userOp = null;
		try {
			userOp = userRepository.findByUserIdAndIsActiveTrue(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new UserServiceException("ERRUR001", "Error occured while fetching user by id " + id, e);
		}

		User user = null;
		if (userOp.isPresent()) {
			user = userOp.get();
			userDTO = MapperUtil.convertToUserDTO(user);
			List<OrderDTO> orderDTOList = null;
			try {
				orderDTOList = orderServiceProxy.getOrderbyUserId(id);
			} catch (FeignException e) {
				log.error("Error connecting to Order service", e);
			}
			userDTO.setOrderDTO(orderDTOList);
		} else {
			String errMsg = "User with id " + id + " not found.";
			log.error(errMsg);
			throw new UserNotFoundException("ERRUR002", errMsg);
		}
		return userDTO;
	}

	@Override
	public void insertUser(UserDTO userDTO) throws UserServiceException {
		try {
			User user = MapperUtil.convertToUser(userDTO);
			userRepository.save(user);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new UserServiceException("ERRUR003", "Error occured while inserting user", e);
		}

	}

	@Transactional
	@Override
	public void deleteUser(long id) throws UserServiceException {
		try {

			userRepository.deactivateUser(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new UserServiceException("ERRUR004", "Error occured while deleting user", e);
		}
		try {
			publisher.publishMessage(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new UserServiceException("ERRUR005", "Error occured while deleting user's order details", e);
		}
	}

}
