package com.acer.redisdemo.service;

import java.util.List;
import java.util.Set;

public interface HelloRedisService {
	public boolean setKeyValues();
	public String getStringValue();
	public Set<String> getHashKeys();
	public List<String> getHashValue();
	public String getListValueByIndex();
	
}
