package com.my.pro.service;

import com.my.pro.model.Cj;
import com.my.pro.utils.Pager;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * 
 */
public interface CjService extends BaseService<Cj>{

	/**
	 * dao层分页查询
	 */
	Pager<Cj> findPager(Cj cj);
}
