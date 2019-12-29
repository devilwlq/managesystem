package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.ClassRoom;
import com.my.pro.utils.Pager;
import com.my.pro.base.impl.BaseDaoImpl;
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

@Repository
public class ClassRoomDaoImpl extends BaseDaoImpl<ClassRoom> implements ClassRoomDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<ClassRoom> findPager(ClassRoom classRoom) {
		if(classRoom.getId() !=null && !"".equals(classRoom.getId() )){
	    	   String hql = "from ClassRoom";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +classRoom.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from ClassRoom where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
