package com.nf.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.nf.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepository {
	
	private final List<User> users = Arrays.asList(new User(1L, "User1"), new User(2L, "User2"));

	public Mono<User> getUserById(String id)
	{
		return Mono.justOrEmpty(
				users.stream()
				.filter(user ->{return user.getId().equals(Long.valueOf(id));})
				.findFirst()
				.orElse(null)
				);
	}
	
	public Mono<User> modifyUser(String id,String name)
	{
		for(User u : users)
		{
			if(u.getId().equals(Long.valueOf(id)))
			{
				u.setUser(name);
			}
		}
		return Mono.empty();
	}
	
	public Flux<User> getUsers()
	{
		return Flux.fromIterable(users);
	}
	
	public static void main(String[] args) {
		UserRepository user = new UserRepository();
		User u = user.users.get(0);
		u.setUser("wangg");
		
		System.out.println(user.users);
	}
 }
