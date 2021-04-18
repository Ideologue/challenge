package com.cegedim.challenge.response;

import java.util.List;

import com.cegedim.challenge.model.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
	private long id;
	private String name;
	private String email;
	private int age;
	private List<Address> addresses;

}
