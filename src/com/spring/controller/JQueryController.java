package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.domain.LoginCommand;
import com.spring.domain.User;

import net.sf.json.JSONObject;

@Controller
public class JQueryController {

	@RequestMapping(value = "/jss", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> sendJson(HttpServletRequest request) {
		System.out.println("go");
		Map<String, Object> map = new HashMap<String, Object>();
		List<LoginCommand> list = new ArrayList<LoginCommand>();
		LoginCommand loginCommand = new LoginCommand();
		loginCommand.setName("name");
		loginCommand.setPassword("password");
		list.add(loginCommand);
		map.put("lala", "str");
		map.put("list", list);
		// JSONObject JSONObject = JSONObject.fromObject(map);
		System.out.println(map.toString());
		return map;
	}

	@RequestMapping(value = "/jsw", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getJson(@RequestBody Map<String, Object> oMap) {

	    JSONObject jsonBean = JSONObject.fromObject(oMap.get("user"));  
	    User user= (User) JSONObject.toBean(jsonBean, User.class);	    
	    System.out.println(user.toString());
//	    JSONObject jsonObject = JSONObject.fromObject(oMap.toString());
//	    Map<String, Object> imMap = (Map<String, Object>) JSONObject.toBean(jsonObject,Map.class);
//	    System.out.println(imMap.get("user"));    
	    
		Map<String, Object> map = new HashMap<String, Object>(1);
		map.put("success", "true");
		return map;
	}
}
