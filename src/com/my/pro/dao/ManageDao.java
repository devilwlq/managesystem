package com.my.pro.dao;

import com.my.pro.base.BaseDao;
import com.my.pro.model.Manage;
import com.my.pro.utils.Pager;

public interface ManageDao extends BaseDao<Manage>{

	Manage login(Manage manage);

	Pager<Manage> list();

	Pager<Manage> listBy(String name);

}
