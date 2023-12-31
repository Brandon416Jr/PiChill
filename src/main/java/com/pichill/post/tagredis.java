package com.pichill.post;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class tagredis {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost", 6379);
		
		jedis.sadd("post:31000009:tags", "大大");

		
		
		
		jedis.close();
	}
}
