package com.nf.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.nf.model.User;
import com.nf.repository.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserHandler {
	
	@Autowired
	private UserRepository userRepository;
	
	public Mono<ServerResponse> handleGetUserById(ServerRequest request)
	{
		return ServerResponse.ok()
				.body(userRepository.getUserById(request.pathVariable("id")), User.class)
				.switchIfEmpty(ServerResponse.notFound().build());
	}
	
	public Mono<ServerResponse> handleGetUsers(ServerRequest request)
	{
		return ServerResponse.ok().body(userRepository.getUsers(), User.class);
	}
	
	public Mono<ServerResponse> handleModifyUsers(ServerRequest request)
	{
		return ServerResponse.ok().body(userRepository.modifyUser(request.pathVariable("id"), request.pathVariable("name")), User.class);
	}
}
