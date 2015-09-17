package com.sf.testObject;

import redis.clients.jedis.Jedis;

public class TestJedisUtil
{
	public static void main(String[] args)
	{
		JedisUtil jedisUtil = JedisUtil.getInstanceOfJedisUtil();
		Jedis jedis = jedisUtil.getJedis("127.0.0.1", 6379);

		jedis.lpush("userList", "zhangsan");
		jedis.lpush("userList", "lisi");
		jedis.lpush("userList", "wangwu");
		
		System.out.println(jedis.lrange("userList", 0, -1));
	}
}
