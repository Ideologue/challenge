package com.cegedim.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cegedim.challenge.model.Address;
import com.cegedim.challenge.model.User;
import com.cegedim.challenge.repository.AddressRepository;
import com.cegedim.challenge.repository.UserRepository;
import com.cegedim.challenge.service.impl.AddressServiceImpl;
import com.cegedim.challenge.service.impl.UserServiceImpl;

public class AddressServiceTest {

	@InjectMocks
	AddressServiceImpl service;

	@Mock
	AddressRepository repo;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void saveTest() {
		Address address = Address.builder().address("adress1").build();

		service.delete(address);

		verify(repo, times(1)).delete(address);

	}

}
