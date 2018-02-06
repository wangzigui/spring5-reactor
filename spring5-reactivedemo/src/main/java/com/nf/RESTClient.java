package com.nf;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.nf.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RESTClient {
	public static void main(final String[] args) {
		final User user = new User();
		user.setId(121L);
		user.setUser("test@example.org");

		final WebClient client = WebClient.create("http://localhost:9000");
//		final Mono<User> createdUser = client.post().uri("/api/user/1").accept(MediaType.APPLICATION_JSON).exchange()
//				.flatMap(response -> response.bodyToMono(User.class));
//		System.out.println(createdUser.block());

		ClientResponse res = client.get().uri("/api/user").accept(MediaType.APPLICATION_JSON).exchange().block();
		Flux<List<User>> list = res.body(BodyExtractors.toFlux(User.class)).buffer();
		List<User> users = list.blockFirst();
		System.out.println(users.get(0));
//				.flatMapMany(response -> response.toEntityList(User.class))
//				.toStream().findAny().
//				ifPresent(System.out::println);
//		List<User> sss = users.toStream().collect(sss);
//		users.toStream().findAny().ifPresent(System.out::println);
	
//		User u = list.get();

//		System.out.println(u);
	}
}
