package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.Cj;
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
public class CjDaoImpl extends BaseDaoImpl<Cj> implements CjDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Cj> findPager(Cj cj) {
		if(cj.getId() !=null && !"".equals(cj.getId() )){
	    	   String hql = "from Cj";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +cj.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Cj where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
