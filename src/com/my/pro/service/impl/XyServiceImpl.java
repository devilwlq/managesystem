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
import com.my.pro.model.Xy;
import com.my.pro.utils.Pager;
import com.my.pro.service.XyService;
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

@Service("xyServiceImpl")
public class XyServiceImpl extends BaseServiceImpl<Xy> implements XyService{
	 
	@Autowired
	private XyDao xyDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Xy> findPager(Xy xy) {
		return xyDao.findPager(xy);
	}
	

	

}
