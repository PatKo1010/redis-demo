package com.acer.redisdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acer.redisdemo.service.HelloRedisService;

@RestController
@RequestMapping(value = "/HelloRedis")
public class HelloRedisController {
	@Autowired
	private HelloRedisService service;
	
	@GetMapping(value = "/setKeyValues")
	public Map<String, Object> setKeyValues (Model model) {
		System.out.println("Hello Redis");
		Boolean result = service.setKeyValues();
		Map<String, Object> resultMap = new HashMap<>();
		if (result) {
			resultMap.put("result", "success");
		}else{
			resultMap.put("resut", "failure");
		}
		return resultMap; 
	}
	
	@GetMapping(value = "/getKeyValues")
	public Map<String, Object> getKeyValues(Model model, @ModelAttribute("action") String action){
		Map<String, Object> resultMap = new HashMap<>();
		if ("getStringValue".equals(action)) {
			resultMap.put("result", service.getStringValue());
		} else if ("getHashValues".equals(action)) {
			List<String> result = service.getHashValue();
			resultMap.put("result", result);
		} else if ("getHashKeys".equals(action)) {
			Set<String> result = service.getHashKeys();
			resultMap.put("result", result);
		} else if ("getListValueByIndex".equals(action)) {
			String result = service.getListValueByIndex();
			resultMap.put("result", result);
		}
		return resultMap;
	}

}
