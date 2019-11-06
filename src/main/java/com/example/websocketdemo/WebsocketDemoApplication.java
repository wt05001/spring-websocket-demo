package com.example.websocketdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * https://www.jianshu.com/p/bfd5200daca7
 * https://www.cnblogs.com/jmcui/p/8999998.html
 * https://github.com/g00glen00b/spring-websockets
 * https://github.com/salmar/spring-websocket-chat
 * https://github.com/callicoder/spring-boot-websocket-chat-demo
 * https://github.com/niezhiliang/springbootwebsocket
 * https://github.com/yudiandemingzi/spring-boot-websocket-study
 */
@EnableScheduling
@SpringBootApplication
public class WebsocketDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketDemoApplication.class, args);
	}
}
