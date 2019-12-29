package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.Xk;
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
public class XkDaoImpl extends BaseDaoImpl<Xk> implements XkDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Xk> findPager(Xk xk) {
		if(xk.getId() !=null && !"".equals(xk.getId() )){
	    	   String hql = "from Xk";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +xk.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Xk where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
