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
		  // dataMap涓殑鏁版嵁灏嗕細琚玈truts2杞崲鎴怞SON瀛楃涓诧紝鎵�浠ヨ繖閲岃鍏堟竻绌哄叾涓殑鏁版嵁
		  jsonMap.clear();
		  User user = new User();
		  user.setPhone("54554");
		  jsonMap.put("user", user);
		  jsonMap.put("success", true);
		  return JSON_TYPE;
	}
}
