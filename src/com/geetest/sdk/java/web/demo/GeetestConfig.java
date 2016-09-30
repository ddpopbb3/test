package com.geetest.sdk.java.web.demo;

/**
 * GeetestWeb配置文件
 * 
 *
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	//private static final String captcha_id = "b46d1900d0a894591916ea94ea91bd2c";
	private static final String captcha_id = "7896ef34a9a0f2573bb7d6e7a2154978";
	
	//private static final String private_key = "36fc3fe98530eea08dfc6ce76e3d24c4";
	private static final String private_key = "9ac6e1492f3904bf51d8cb16391fec45";
	
	public static final String getCaptcha_id() {
		return captcha_id;
	}

	public static final String getPrivate_key() {
		return private_key;
	}

}
