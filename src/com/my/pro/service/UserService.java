package com.my.pro.service;

import java.util.List;

import com.my.pro.model.User;
import com.my.pro.utils.Pager;


public interface UserService extends BaseService<User> {
	public List<User> listAllCanSendUser(int userId);

	public void add(User user);

	public User load(User user);

	public User getUser(int userId);

	public List<User> findFriend(String userName, int myId);

	public User loadUserById(int userId);

	public Pager<User> listAll(String userName);

	public void delUse(int userId);

	public List<User> findSYuser();

	public List<User> findBYuser();

	public User isregister(User user);

	public Integer save2(User user);

}
