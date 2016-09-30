package com.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geetest.sdk.java.GeetestLib;
import com.geetest.sdk.java.web.demo.GeetestConfig;
import com.spring.domain.LoginCommand;

@Controller
public class JiyanController {
	
	@RequestMapping(value = "/userLogin.do" ,method = RequestMethod.POST)
	@ResponseBody
	public String userLogin(String geetest_challenge, String geetest_validate,String geetest_seccode,LoginCommand loginCommand,HttpSession session){
		
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getCaptcha_id(), GeetestConfig.getPrivate_key());
		
		System.out.println(geetest_challenge+geetest_validate+geetest_seccode+loginCommand.toString());
		
		//从session中获取gt-server状态
				int gt_server_status_code = (Integer) session.getAttribute(gtSdk.gtServerStatusSessionKey);
				
				//从session中获取userid
				String userid = (String)session.getAttribute("userid");
				
				System.out.println(gt_server_status_code+userid);
				
				int gtResult = 0;

				if (gt_server_status_code == 1) {
					//gt-server正常，向gt-server进行二次验证
						
					gtResult = gtSdk.enhencedValidateRequest(geetest_challenge, geetest_validate, geetest_seccode, userid);
					System.out.println(gtResult);
				} else {
					// gt-server非正常情况下，进行failback模式验证
						
					System.out.println("failback:use your own server captcha validate");
					gtResult = gtSdk.failbackValidateRequest(geetest_challenge, geetest_validate, geetest_seccode);
					System.out.println(gtResult);
				}


				if (gtResult == 1) {
					// 验证成功
					return "success";
					/*PrintWriter out = response.getWriter();
					JSONObject data = new JSONObject();
					try {
						data.put("status", "success!!!!");
						data.put("version", gtSdk.getVersionInfo());
					} catch (JSONException e) {
						e.printStackTrace();
					}
					out.println(data.toString());*/
				}
				else {
					// 验证失败
					return "fail";
					/*JSONObject data = new JSONObject();
					try {
						data.put("status", "fail");
						data.put("version", gtSdk.getVersionInfo());
					} catch (JSONException e) {
						e.printStackTrace();
					}
					PrintWriter out = response.getWriter();
					out.println(data.toString());*/
				}
	}
	@RequestMapping(value = "/userLogin.do" ,method = RequestMethod.GET)
	@ResponseBody
	public String userPreLogin(HttpSession session){

		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getCaptcha_id(), GeetestConfig.getPrivate_key());

		String resStr = "{}";
		
		//自定义userid
		String userid = "test";

		//进行验证预处理
		int gtServerStatus = gtSdk.preProcess(userid);
		
		//将服务器状态设置到session中
		session.setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
		
		//将userid设置到session中
		session.setAttribute("userid", userid);
		
		resStr = gtSdk.getResponseStr();
		
		return resStr;
	}
}
