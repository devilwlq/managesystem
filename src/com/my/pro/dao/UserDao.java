package com.my.pro.dao;

import java.util.List;

import com.my.pro.base.BaseDao;
import com.my.pro.model.User;
import com.my.pro.utils.Pager;



public interface UserDao extends BaseDao<User>{
	public List<User> listAllCanSendUser(int userId);
	User add(User t);
	public User load(User user);
	public List<User> findFriend(String userName);
	public List<User> loadTuiJian(User you);
	public Pager<User> listAll();
	public Pager<User> finAllByName(String userName);
	public List<User> findSYuser();
	public List<User> findBYuser();
	public User isregister(User user);

}
