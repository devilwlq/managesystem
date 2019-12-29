package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.Zy;
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
public class ZyDaoImpl extends BaseDaoImpl<Zy> implements ZyDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Zy> findPager(Zy zy) {
		if(zy.getId() !=null && !"".equals(zy.getId() )){
	    	   String hql = "from Zy";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +zy.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Zy where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
