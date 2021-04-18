package com.cegedim.challenge.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cegedim.challenge.exception.UserNotFoundException;
import com.cegedim.challenge.model.User;
import com.cegedim.challenge.service.AddressService;
import com.cegedim.challenge.service.UserService;

@RestController("UserController")
@CrossOrigin
@RequestMapping(value = { "/users" })
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private AddressService addressService;

	@PostMapping
	private User createUser(@Valid @RequestBody User user) {

		
		return service.save(user);

	}

	@PutMapping("/{id}")
	private User updateUser(@PathVariable long id, @Valid @RequestBody User userToupdate) throws UserNotFoundException {
		Optional<User> optional = service.findById(id);
		optional.orElseThrow(() -> new UserNotFoundException("user not found"));
		userToupdate.setId(id);
		
		return service.save(userToupdate);
	}

	@DeleteMapping("/{id}")
	private void deleteUser(@PathVariable long id) throws UserNotFoundException {
		Optional<User> optional = service.findById(id);
		if (!optional.isPresent())
			throw new UserNotFoundException("User Not Found");
		optional.get().getAddresses().forEach(address -> {
			addressService.delete(address);
		});
		service.delete(optional.get());
	}

	@GetMapping("/{id}")
	private User getUser(@PathVariable long id) throws UserNotFoundException {
		Optional<User> optional = service.findById(id);
		if (!optional.isPresent())
			throw new UserNotFoundException("User Not Found");
		return optional.get();
	}

	@GetMapping
	private List<User> getAllUsers() {
		List<User> users = service.findAll();
		return users;

	}
}
