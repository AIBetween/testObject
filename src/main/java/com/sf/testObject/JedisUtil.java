package com.sf.testObject;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil
{
	private JedisUtil()
	{
		
	}
	private static Map<String, JedisPool> jedisPoolGroup = new HashMap<String, JedisPool>();
	private static Logger logger = LoggerFactory.getLogger(JedisUtil.class);
	
	public static JedisPool getJedisPool(String ip, int port)
	{
		JedisPool poolOfReturn = null;
		String key = new StringBuffer("ip:").append(port).toString();
		
		if(!jedisPoolGroup.containsKey(key))
		{
			if(null != (poolOfReturn = createJedisPool(ip, port)))
			{
				jedisPoolGroup.put(key, poolOfReturn);
			}
		}
		else
			poolOfReturn = jedisPoolGroup.get(key);
		
		
		return poolOfReturn;
		
	}
	
	/**
	 * 创建 给定ip和端口 的redis连接池
	 * @param ip
	 * @param port
	 * @return
	 */
	private static JedisPool createJedisPool(String ip,int port)
	{
		JedisPoolConfig configOfJedisPool = new JedisPoolConfig();
		configOfJedisPool.setTestOnBorrow(true);
		configOfJedisPool.setTestOnReturn(true);
		
		JedisPool poolOfCreate = null;
		try {
			poolOfCreate = new JedisPool(configOfJedisPool, ip, port);
			
		} catch (Exception e) {
			logger.error("生成ip为{}，端口为{}的redis连接失败，请重试！", ip, port);
			e.printStackTrace();
		}
		
		return poolOfCreate;
	}
	
	public Jedis getJedis(String ip, int port)
	{
		Jedis jedisOfReturn = null;
		
		if(isIpAndPortLegal(ip, port))
		{
			int maxTryTimes = 3;
			int currentTime = 1;
			do{
				try {
					jedisOfReturn = getJedisPool(ip, port).getResource();
				} catch (Exception e) {
					logger.error("第{}次获取 ip为{}，端口为{}的redis连接失败，还会进行{}尝试", currentTime,ip,port,maxTryTimes -currentTime);
					getJedisPool(ip,port).returnBrokenResource(jedisOfReturn);  

				}
			}while(jedisOfReturn == null && currentTime <= maxTryTimes);
		}
		else
			logger.warn("ip为{}，Port为{}，参数不合法，返回为null", ip, port);
		
		return jedisOfReturn;
		
	}
	private boolean isIpAndPortLegal(String ip, int port)
	{
		boolean legitimacy = true;
		
		if("".equals(ip))
			legitimacy = false;
		if(port < 0 || port > 65535)
			legitimacy  = false;
		
		return legitimacy;
	}
	
	public void closeJedis(Jedis jedisOfClose, String ip, int port)
	{
		getJedisPool(ip, port).returnResource(jedisOfClose);
	}
	
	public static JedisUtil getInstanceOfJedisUtil()
	{
		return new JedisUtil();
	}
}
