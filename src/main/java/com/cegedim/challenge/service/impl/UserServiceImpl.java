package com.cegedim.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cegedim.challenge.model.User;
import com.cegedim.challenge.repository.UserRepository;
import com.cegedim.challenge.service.UserService;

/**
 * @author ibrahim
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;

	@Override
	public User save(User user) {
		user.getAddresses().forEach(address -> {
			address.setUser(user);
		});
		return repository.save(user);
	}

	@Override
	public Optional<User> findById(long id) {

		return repository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) repository.findAll();
	}

	@Override
	public void delete(User user) {
		repository.delete(user);

	}

}
