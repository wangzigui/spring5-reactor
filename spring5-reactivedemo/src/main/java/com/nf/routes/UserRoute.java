package com.nf.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import com.nf.handler.UserHandler;

@Configuration
public class UserRoute {
	
	@Autowired
	private UserHandler userHandler;

//	public UserRoute(UserHandler userHandler) {
//		this.userHandler = userHandler;
//	}
	
	@Bean
	public RouterFunction<?> routerFunction()
	{
		return route(GET("/api/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::handleGetUsers)
				.andRoute(RequestPredicates.POST("/api/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::handleGetUserById)
				.andRoute(RequestPredicates.POST("/api/user/{id}/{name}").and(accept(MediaType.APPLICATION_JSON)), userHandler::handleModifyUsers);
//				.and(route(GET("/api/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::handleGetUserById));
	}
	
}

