package com.example.demo.domain;

import com.example.demo.infrastructure.UserEntity;
import com.example.demo.infrastructure.SpringDataHibernateUserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class UserServiceImpl implements UserService {	// Business Logic Layer
	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers() throws DomainException {
		List<UserEntity> userEntityList = userRepository.findAll();
		List<User> userList = new ArrayList<>();
		for (UserEntity userEntity:userEntityList) {
			userList.add(new User(userEntity.getId(), userEntity.getName()));
		}
		return userList;
	}

	@Override
	public User createUser(Long id, String name) throws DomainException{
		User user = userRepository.createUser(new User(id, name)); // save -> create a new entry if it can't find the id specified /
																					// update otherwise
		return new User(user.getId(), user.getName());
	}

}
