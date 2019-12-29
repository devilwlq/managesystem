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
import com.my.pro.model.Xk;
import com.my.pro.utils.Pager;
import com.my.pro.service.XkService;
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

@Service("xkServiceImpl")
public class XkServiceImpl extends BaseServiceImpl<Xk> implements XkService{
	 
	@Autowired
	private XkDao xkDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Xk> findPager(Xk xk) {
		return xkDao.findPager(xk);
	}
	

	

}
