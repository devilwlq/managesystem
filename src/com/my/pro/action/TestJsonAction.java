package com.my.pro.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.my.pro.model.User;
import com.my.pro.utils.ResultTypeUtils;
import com.opensymphony.xwork2.ActionSupport;

@Controller("textjsonAction")
@Scope("prototype")
public class TestJsonAction extends BaseAction{
	

	private String dd;
	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	

	public String testByAction() {
		  // dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据
		  jsonMap.clear();
		  User user = new User();
		  user.setPhone("54554");
		  jsonMap.put("user", user);
		  jsonMap.put("success", true);
		  return JSON_TYPE;
	}
}
