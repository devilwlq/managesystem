package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.Xy;
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
public class XyDaoImpl extends BaseDaoImpl<Xy> implements XyDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Xy> findPager(Xy xy) {
		if(xy.getId() !=null && !"".equals(xy.getId() )){
	    	   String hql = "from Xy";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +xy.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Xy where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
