package com.my.pro.utils;



import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.my.pro.model.Manage;
import com.my.pro.model.User;




/**
 * 判断当前登陆角色和信息
 * @author 
 *
 */
public class UserUtils {
	
	/**
	 * 获取当前登陆的用户
	 * @return
	 */
	public static User getUser(){
		//将用户信息放入session
		HttpSession session = ServletActionContext.getRequest().getSession();
		try {
			User user = (User)session.getAttribute("user");
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * 获取当前登陆的管理员
	 * @return
	 */
	public static Manage getManage(){
		//将用户信息放入session
		HttpSession session = ServletActionContext.getRequest().getSession();
		try {
			Manage manage = (Manage)session.getAttribute("manage");
			return manage;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 获取当前登陆的id
	 * @return
	 */
	public static Integer getLoginId(){
		//将用户信息放入session
		HttpSession session = ServletActionContext.getRequest().getSession();
		try {
			Integer id = Integer.valueOf(session.getAttribute("userId").toString());
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 获取当前登陆的名字
	 * @return
	 */
	public static String  getLoginName(){
		//将用户信息放入session
		HttpSession session = ServletActionContext.getRequest().getSession();
		try {
			String name = session.getAttribute("userName").toString();
			return name;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
