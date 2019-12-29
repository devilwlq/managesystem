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
import com.my.pro.model.Zy;
import com.my.pro.utils.Pager;
import com.my.pro.service.ZyService;
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

@Service("zyServiceImpl")
public class ZyServiceImpl extends BaseServiceImpl<Zy> implements ZyService{
	 
	@Autowired
	private ZyDao zyDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Zy> findPager(Zy zy) {
		return zyDao.findPager(zy);
	}
	

	

}
