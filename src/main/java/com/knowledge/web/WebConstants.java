package com.knowledge.web;

/**
 * web端用到的一些静态常量
 * 
 * @author WanWei
 * @date 2016-4-29 上午8:57:31
 */
public interface WebConstants {

	//主页面路径
	public static final String BASE_PAGE_URL = "home";
	
	//主页面路径
	public static final String BASE_PAGE_URL_DEV = "home-dev";
	
	//微信主页面路径
	public static final String WECHAT_BASE_PAGE_URL = "wechat";
	
	//微信主页面路径
	public static final String WECHAT_BASE_PAGE_URL_DEV = "wechat-dev";
	
	//重定向页面
	public static final String REDIREC_PATH = "/router/login";
	
	//登录页面
	public static final String LOGIN_PATH = "/router/login";
	
	//router为react框架配置的路径前缀
	public static final String REACT_ROUTER_PATH = "/router";
	
	//暂存用户在线状态的缓存名称
	public static final String USER_ONLINE_CACHE = "user_online_cache";
	
	//暂存用户session
	public static final String USER_SESSION_CACHE = "user_session_cache";

	//暂存面试间聊天信息
	public static final String USER_MESSAGE_CACHE = "user_message_cache";
	
	//暂存URL请求的访问记录
	public static final String URL_ACCESS_FREQUENCY_CACHE = "url_access_frequency_cache";

	//暂存面试间聊天信息
	public static final String FAIRPLACE_STATUS_CACHE = "fairplace_status_cache";
	
	// HTTPS认证文件路径
	public static final String AUTH_HTTPS_PATH = "/auth/push_keystore.jks";
	
	// HTTPS认证密码
	public static final String AUTH_HTTPS_PASSWORD = "pushi123";
	
	// JWT用到的sign前缀
	public static final String TOKEN_STRING = "jwt_token";
	
	//HTTPS端口
	public static final int HTTPS_PORT = 8443;
	
	//HTTP端口
	public static final int HTTP_PORT = 8089;
	
	//用来做AES加密解密的IV设置，固定设置为32个1
	public static final String IV_AES = "11111111111111111111111111111111";

	//用来封装加密参数的可以值
	public static final String ENCRYPT_PARAMS_KEY = "pushi_params";
	
	//login解密 
	public static final String IV_KEY = "21a361d96e3e13f5";
	
	//识别业务异常的异常码
	public static final String ECODE = "ecode";
}
