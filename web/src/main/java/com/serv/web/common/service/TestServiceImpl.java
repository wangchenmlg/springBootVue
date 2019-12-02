package com.serv.web.common.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("test")
public class TestServiceImpl implements TestService {

	@Override
	public Map<String, Object> refTest() {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("test", "service 关联调用 【成功】");
		return res;
	}

}
