/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.my.pro.model.ClassRoom;
import com.my.pro.utils.Pager;
import com.my.pro.service.ClassRoomService;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * 
 */

@Service("classRoomServiceImpl")
public class ClassRoomServiceImpl extends BaseServiceImpl<ClassRoom> implements ClassRoomService{
	 
	@Autowired
	private ClassRoomDao classRoomDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<ClassRoom> findPager(ClassRoom classRoom) {
		return classRoomDao.findPager(classRoom);
	}
	

	

}
