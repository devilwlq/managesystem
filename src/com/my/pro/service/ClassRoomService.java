package com.my.pro.service;

import com.my.pro.model.ClassRoom;
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
public interface ClassRoomService extends BaseService<ClassRoom>{

	/**
	 * dao层分页查询
	 */
	Pager<ClassRoom> findPager(ClassRoom classRoom);
}
