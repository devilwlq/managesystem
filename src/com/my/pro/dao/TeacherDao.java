package com.my.pro.dao;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import com.my.pro.utils.Pager;
import com.my.pro.base.BaseDao;
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


public interface TeacherDao extends BaseDao<Teacher>{
	
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	Pager<Teacher> findPager(Teacher teacher);
}
