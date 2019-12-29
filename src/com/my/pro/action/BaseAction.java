package com.my.pro.action;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	//返回success
		public static final String SUSSESS = "SUCCSEE";
		
		//返回json
		public static final String JSON_TYPE = "json";
		
		//挑转
		public static final String RETIRCT_URL = "redirect";
		
		//chain
		public static final String CHAIN = "chain";

		public Map<String, Object> jsonMap = new HashMap<String, Object>();
		//===================================================================
		public Map<String, Object> getJsonMap() {
			return jsonMap;
		}
	
		public void setJsonMap(Map<String, Object> jsonMap) {
			this.jsonMap = jsonMap;
		}
	//===================================================================
		
			/**
			 * 獲取request
			 * @return
			 */
			public HttpServletRequest getRequest() {
		
				return ServletActionContext.getRequest();
		
			}
		
			/**
			 * 获取response
			 * @return
			 */
			public HttpServletResponse getResponse() {
		
				return ServletActionContext.getResponse();
		
			}
		
			public HttpSession getSession() {
		
				return getRequest().getSession();
		
			}
		
			public ServletContext getServletContext() {
		
				return ServletActionContext.getServletContext();
		
			}
			
			/**
			 * 存值
			 * @return
			 */
			public ActionContext getActionContext(){
				return ActionContext.getContext();
			}
			
		
			public String getRealyPath(String path) {
				return getServletContext().getRealPath(path);
		
			}
			
			//判断非空
			public  boolean isEmpty(final String str) {
				return (null == str) || (str.trim().length() <= 0);
			}

			
			public  boolean isEmpty(final Character cha) {
				return ( null==cha) || cha.equals(' ');
			}

			
			public  boolean isEmpty(final Object obj) {
				return (null==obj);
			}


			public  boolean isEmpty(final Object[] objs) {
				return (null==objs) || (objs.length <= 0);
			}

			
			public  boolean isEmpty(final Collection<?> obj) {
				return (null==obj) || obj.isEmpty();
			}


			
			public  boolean isEmpty(final Set<?> set) {
				return (null==set) || set.isEmpty();
			}

			
			public  boolean isEmpty(final Serializable obj) {
				return null==obj;
			}

			
			public  boolean isEmpty(final Map<?, ?> map) {
				return (null==map) || map.isEmpty();
			}


}