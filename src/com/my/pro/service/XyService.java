package com.my.pro.service;

import com.my.pro.model.Xy;
import com.my.pro.utils.Pager;
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
public interface XyService extends BaseService<Xy>{

	/**
	 * dao层分页查询
	 */
	Pager<Xy> findPager(Xy xy);
}
