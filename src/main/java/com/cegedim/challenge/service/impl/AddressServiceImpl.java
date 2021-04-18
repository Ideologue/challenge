package com.cegedim.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cegedim.challenge.model.Address;
import com.cegedim.challenge.repository.AddressRepository;
import com.cegedim.challenge.service.AddressService;

/**
 * @author ibrahim
 *
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;
	@Override
	public void delete(Address address) {
		addressRepository.delete(address);
		
	}

}
