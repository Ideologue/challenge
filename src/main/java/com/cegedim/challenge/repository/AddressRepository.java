package com.cegedim.challenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cegedim.challenge.model.Address;

/**
 * @author Ibrahim
 *
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
