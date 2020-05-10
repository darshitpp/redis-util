package com.darshitpp.redis.redisutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.darshitpp.redis.redisutil"})
public class RedisUtilApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisUtilApplication.class, args);
	}

}
