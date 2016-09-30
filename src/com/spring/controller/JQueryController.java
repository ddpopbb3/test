package com.spring.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.FabricCommunicationException;
import com.spring.domain.LoginCommand;
import com.spring.domain.User;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import net.sf.json.JSONObject;
import test.MyCaptchaUtils;
import test.MyCaptchaUtils.Level;


@Controller
public class JQueryController {
	
	

	//访问服务器的时间
	public String time = new String(System.currentTimeMillis()+"");

	@RequestMapping(value = "/jss", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> sendJson(HttpServletRequest request) throws IOException, FabricCommunicationException {
		
		//获取服务器目录内的项目路径
		//根据加载的类来获取编译好的class的路径
		String path = JQueryController.class.getResource(JQueryController.class.getSimpleName()+".class").toString();
		
		URL xmlpath = this.getClass().getClassLoader().getResource("");  
        System.out.println(xmlpath);
		
		System.out.println(path);
		//处理字符串得到webContent
		String[] array= new String[10];
		array=path.split("MyChapter");
		array = array[0].split("file:/");
		path  = array[1]+"MyChapter/captcha";
		
		//通过request来获取webContent
		//String path=request.getSession().getServletContext().getRealPath("captcha");
		
		//以访问时间为标识存放验证码图片
		File file = new File(path+File.separator+time+".jpg");
		System.out.println(path);
		
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

		//随机生成验证码图片
		MyCaptchaUtils myCaptchaUtils = new MyCaptchaUtils();
		
		Object[] obj=myCaptchaUtils.getCaptcha(150, 50, 35, 50, 500, true,true, Level.easy,false,true);
		
		ImageIO.write((BufferedImage)obj[0],"jpg",file);
		
		//密钥
		System.out.println("验证码"+obj[1]);
		
		//将验证码图片的存放路径发给页面
		map.put("lili", "captcha\\"+time+".jpg");
		
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
	
	@RequestMapping(value = "/Captcha", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getCaptcha(HttpSession session) throws IOException, FabricCommunicationException {
		
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

		//随机生成验证码图片
		MyCaptchaUtils myCaptchaUtils = new MyCaptchaUtils();
		
		Object[] obj=myCaptchaUtils.getCaptcha(150, 50, 35, 50, 500, true,true, Level.easy,false,true);
		
		 byte[] captchaChallengeAsJpeg = null;
	        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
	        try {
	            BufferedImage challenge = (BufferedImage)obj[0];
	            JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
	            jpegEncoder.encode(challenge);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
	        
	        map.put("lilia", captchaChallengeAsJpeg);
		
		//密钥
		System.out.println("验证码"+obj[1]);
		session.setAttribute("key", obj[1]);
		System.out.println(map.toString());
		
		return map;
	}
	
	@RequestMapping(value = "/Captcha2", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getCaptcha2(HttpSession session) throws IOException, FabricCommunicationException {
		
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

		//随机生成验证码图片
		MyCaptchaUtils myCaptchaUtils = new MyCaptchaUtils();
		
		Object[] obj=myCaptchaUtils.getCaptcha2(150, 50, 35, 50, 500, true,true, Level.easy,false,true);
		
		 
	        map.put("lilia", obj[0]);
		
		//密钥
		System.out.println("验证码"+obj[1]);
		session.setAttribute("key", obj[1]);
		System.out.println(map.toString());
		
		return map;
	}
	
	@RequestMapping(value = "/app", method = RequestMethod.POST)
	@ResponseBody
	public String verify(LoginCommand loginCommand,String captcha,HttpSession session) {
 
		System.out.println(loginCommand.toString()+captcha);
	    String  key = (String) session.getAttribute("key");
	    if(key.equals(captcha))
		return "success";
	    else
	    	return "fail";
	}
}
