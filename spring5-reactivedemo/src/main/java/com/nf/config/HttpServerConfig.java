package com.nf.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import reactor.ipc.netty.http.server.HttpServer;

@Configuration
public class HttpServerConfig {

//	@Autowired
//	private Environment environment;
	
	@Value("${server.port}")
	private Integer port;
	
	@Bean
	public HttpServer httpServer(RouterFunction<?> routerFunction)
	{
		HttpHandler handler = RouterFunctions.toHttpHandler(routerFunction);
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
//		HttpServer httpServer = HttpServer.create("localhost", Integer.valueOf(environment.getProperty("server.port")));
		HttpServer httpServer = HttpServer.create(port);
		httpServer.newHandler(adapter);
		
		return httpServer;
	}
}
