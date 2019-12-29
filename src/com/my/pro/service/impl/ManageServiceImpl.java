package com.my.pro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.pro.dao.ManageDao;
import com.my.pro.model.Manage;
import com.my.pro.service.ManageService;
import com.my.pro.utils.Pager;


@Service("manageService")
public class ManageServiceImpl extends BaseServiceImpl<Manage> implements ManageService {
     @Autowired
	 private ManageDao manageDao;
   	public Manage login(Manage manage) {
		 Manage m = new Manage();
		 m.setName(manage.getName());
		 m.setPassWord(manage.getPassWord());
		return manageDao.login(m);
	}
	public Pager<Manage> list(Manage manage) {
		// TODO Auto-generated method stub
		if(manage.getName()!=null && !"".equals(manage.getName())){
			return manageDao.listBy(manage.getName());
		}else{
			return manageDao.list();
		}
		 
	}
	public void updateInfo(Manage manage) {
		manageDao.update(manage);
	}
	public void deleteInfo(int id) {
		// TODO Auto-generated method stub
		manageDao.delete(id);
	}
	

}
