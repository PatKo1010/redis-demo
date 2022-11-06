package com.acer.redisdemo.service.serviceImpl.UserServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import com.acer.redisdemo.entity.User;
import com.acer.redisdemo.service.HelloRedisService;

@Service
public class HelloRedisServiceImpl implements HelloRedisService {
	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Override
	public boolean setKeyValues() {
		try {
			//put string
			//opsForValue
			ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
			valueOps.set("String:1", "StringVaule1");
			valueOps.set("String:2","StringVaule2", 30, TimeUnit.MINUTES);
			
			//put Hash
			HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
			hashOps.put("HashKey:1", "SmallKey0", "HashVaue0");
			
			HashOperations<String, String, Object> hashOps2 = redisTemplate.opsForHash();
			HashMap<String, String> hashmap = new HashMap<> ();
			hashmap.put("smallKey1", "HashValue1");
			hashmap.put ("smallKey2", "HashValue2");
			hashOps2.putAll("HashKey:2", hashmap);
			hashOps2.put("HashKey:3", "smallkey1", new User());
			
			//put Set
			SetOperations<String, String> setOps = redisTemplate.opsForSet();
			setOps.add("setKey:1", "SetValue1", "setValue2", "setValue3");
			
			//put list
			ListOperations<String, String> opsList = redisTemplate.opsForList();
			opsList.leftPush("listKey:0", "listLeftValue");
			opsList.rightPush("listKey:0", "listRightValue");
			
			ArrayList<String> list = new ArrayList<>();
			list.add("listValue0");
			list.add("listValue1");
			opsList.rightPushAll("listKey:0", list);
			
			//
			ZSetOperations<String, String> zSetOps = redisTemplate.opsForZSet();
			zSetOps.add("zSetKey", "A", 100D);
			zSetOps.add("zSetKey", "B", 200D);
			
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public String getStringValue() {
		ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
		return valueOps.get("String:1");
		
	}
	
	@Override
	public Set<String> getHashKeys() {
		HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
		Set<String> keys = hashOps.keys("HashKey:1");
		return keys;
	}

	@Override
	public List<String> getHashValue() {
		HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
		List<String> values = hashOps.values("HashKey:1");
		return values;
	}

	@Override
	public String getListValueByIndex() {
		String listKey = (String) redisTemplate.boundListOps("listKey:0").index(3);
		return listKey;
	}

	
	
}
