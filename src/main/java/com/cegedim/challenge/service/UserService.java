package com.cegedim.challenge.service;

import java.util.List;
import java.util.Optional;

import com.cegedim.challenge.model.User;

public interface UserService {
	User save(User user);

	Optional<User> findById(long id);

	List<User> findAll();

	void delete(User user);
}
