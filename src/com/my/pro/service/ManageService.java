package com.my.pro.service;

import com.my.pro.model.Manage;
import com.my.pro.utils.Pager;

public interface ManageService  extends BaseService<Manage>{

	Manage login(Manage manage);

	Pager<Manage> list(Manage manage);

	void updateInfo(Manage manage);

	void deleteInfo(int id);

}
