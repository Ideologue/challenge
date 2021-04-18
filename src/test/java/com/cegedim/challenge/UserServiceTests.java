package com.cegedim.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cegedim.challenge.model.Address;
import com.cegedim.challenge.model.User;
import com.cegedim.challenge.repository.UserRepository;
import com.cegedim.challenge.service.impl.UserServiceImpl;

public class UserServiceTests {

	@InjectMocks
	UserServiceImpl service;

	@Mock
	UserRepository repo;

	Address[] addresses = new Address[] { Address.builder().address("adress1").build(),
			Address.builder().address("adress1").build() };

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void findByIdTest() {

		when(repo.findById(1L))
				.thenReturn(Optional.of(new User(1L, "ibrahim", "user@email.com", 22, Arrays.asList(addresses))));

		User user = service.findById(1L).get();

		assertEquals("ibrahim", user.getName());
		assertEquals("user@email.com", user.getEmail());
	}

	@Test
	public void saveTest() {
		User user = new User(1L, "Ibrahim", "user@email.com", 18, Arrays.asList(addresses));
		when(repo.save(user))
		.thenReturn(new User(1L, "Ibrahim", "user@email.com", 18, Arrays.asList(addresses)));
		User newUser = service.save(user);

		verify(repo, times(1)).save(user);
		assertEquals("Ibrahim", newUser.getName());
		assertEquals("user@email.com", newUser.getEmail());
	}

	@Test
	public void findAllTest() {
		User user = new User(1L, "Ibrahim", "user@email.com", 18, Arrays.asList(addresses));
		User user2 = new User(2L, "Ali", "user2@email.com", 18, Arrays.asList(addresses));
		User[] users = new User[] { user, user2 };
		when(repo.findAll()).thenReturn(Arrays.asList(users));
		List<User> found = service.findAll();

		verify(repo, times(1)).findAll();
		assertEquals("Ibrahim", found.get(0).getName());
		assertEquals("user@email.com", found.get(0).getEmail());
		assertEquals("Ali", found.get(1).getName());
		assertEquals("user2@email.com", found.get(1).getEmail());
	}

	@Test
	public void deleteTest() {
		User user = new User(1L, "Ibrahim", "user@email.com", 18, Arrays.asList(addresses));

		service.delete(user);

		verify(repo, times(1)).delete(user);

	}

}
