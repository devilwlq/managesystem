package com.my.pro.service;

import com.my.pro.model.Teacher;
import com.my.pro.utils.Pager;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * 
 */
public interface TeacherService extends BaseService<Teacher>{

	/**
	 * dao层分页查询
	 */
	Pager<Teacher> findPager(Teacher teacher);
}
