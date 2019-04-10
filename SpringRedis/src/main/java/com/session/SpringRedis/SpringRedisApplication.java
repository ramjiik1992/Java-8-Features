package com.session.SpringRedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)
public class SpringRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}

	/*
	 * @Value("${spring.session.timeout}") private Integer
	 * maxInactiveIntervalInSeconds;
	 * 
	 * @Bean public RedisOperationsSessionRepository
	 * sessionRepository(RedisConnectionFactory factory) {
	 * RedisOperationsSessionRepository sessionRepository = new
	 * RedisOperationsSessionRepository(factory);
	 * sessionRepository.setDefaultMaxInactiveInterval(maxInactiveIntervalInSeconds)
	 * ; return sessionRepository; }
	 */
}
