package com.glaway.myspringboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @filename: 		MyRedisController
 * @copyright: 		版权所有 2020-2025 南京国睿信维软件有限公司
 * @version: 		V1.0
 * @author: 		FZH
 * @createtime: 	2020年09月09日11:47
 * @description:
 *        Redis测试类
 */
@RestController
@RequestMapping("/redis")
public class MyRedisController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Bean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		return new StringRedisTemplate(redisConnectionFactory);
	}

	@GetMapping("/hello")
	public String helloRedis(String key) {
		stringRedisTemplate.opsForValue().set("hello","word");
		// stringRedisTemplate.opsForValue().get("hello")
		BoundValueOperations<String, String> boundValueOps = stringRedisTemplate.boundValueOps("name");
		boundValueOps.set("张三");
		return boundValueOps.get() + stringRedisTemplate.opsForValue().get("hello");
	}

}
