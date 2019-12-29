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
import com.my.pro.model.Cj;
import com.my.pro.utils.Pager;
import com.my.pro.service.CjService;
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

@Service("cjServiceImpl")
public class CjServiceImpl extends BaseServiceImpl<Cj> implements CjService{
	 
	@Autowired
	private CjDao cjDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Cj> findPager(Cj cj) {
		return cjDao.findPager(cj);
	}
	

	

}
