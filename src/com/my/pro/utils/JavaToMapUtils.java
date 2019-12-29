package com.my.pro.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class JavaToMapUtils {
	 public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {    
	        if (map == null)  
	            return null;  
	  
	        Object obj = beanClass.newInstance();  
	  
	        org.apache.commons.beanutils.BeanUtils.populate(obj, map);  
	  
	        return obj;  
	    }    
	      
	    public static Map<?, ?> objectToMap(Object obj) {  
	        if(obj == null)  
	            return null;   
	  
	        return new org.apache.commons.beanutils.BeanMap(obj);  
	    }    
	    
	 // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map  
	    public static Map<String, Object> transBean2Map(Object obj) {  
	  
	        if(obj == null){  
	            return null;  
	        }          
	        Map<String, Object> map = new HashMap<String, Object>();  
	        try {  
	            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
	            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
	            for (PropertyDescriptor property : propertyDescriptors) {  
	                String key = property.getName();  
	  
	                // 过滤class属性  
	                if (!key.equals("class")) {  
	                    // 得到property对应的getter方法  
	                    Method getter = property.getReadMethod();  
	                    Object value = getter.invoke(obj);  
	  
	                    map.put(key, value);  
	                }  
	  
	            }  
	        } catch (Exception e) {  
	            System.out.println("transBean2Map Error " + e);  
	        }  
	  
	        return map;  
	  
	    }  
}
