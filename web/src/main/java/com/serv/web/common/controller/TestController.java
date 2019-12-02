package com.serv.web.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serv.web.common.service.TestService;
import com.serv.web.tools.MapUtil;

@RestController
public class TestController {
	@Autowired  
    HttpServletRequest request;
	
	@Autowired
	@Qualifier("test")
	TestService testServ;

	@RequestMapping("/test/contl.do")
    public Map<String, Object> helloworld(){
		//   http://127.0.0.1:8090/test/contl.do
		Map<String, Object> res = new HashMap<String, Object>();
		Map<String, Object> para = MapUtil.getParaMap(request);
    	res.put("getTheKey", "json");
    	res.put("uesTec", "springBoot");
    	res.put("china", "中文の测试！~~~~");
    	res.put("receive", para);
    	return res;
	}
	
	@RequestMapping("/test/ref.do")
    public Map<String, Object> refTest(){
		return testServ.refTest();
	}
}
