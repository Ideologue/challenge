package com.cegedim.challenge.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cegedim.challenge.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
