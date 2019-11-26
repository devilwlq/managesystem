package com.my.pro.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.pro.dao.UserDao;
import com.my.pro.model.User;
import com.my.pro.service.UserService;
import com.my.pro.utils.Pager;


@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
    @Autowired
	private UserDao userdao;
	public List<User> listAllCanSendUser(int userId) {
		return userdao.listAllCanSendUser(userId);
	}
	public void add(User user) {
		userdao.add(user);
	}
	public User load(User user) {
		return userdao.load(user);
	}
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return userdao.load(userId);
	}
	/*@Override
	public List<User> findFriend(String userName,int myId) {
		// TODO Auto-generated method stub
		List<User> us = new ArrayList<User>();
		List<User> users=  userdao.findFriend(userName);
		//排除已经添加过得
		for(User u : users){
			Friend ch =friendDao.checkIsFriend(u.getId(),myId);
			if(ch==null){
				us.add(u);
			}
		}
		
		return us;
	}*/
	public User loadUserById(int userId) {
		// TODO Auto-generated method stub
		return userdao.load(userId);
	}
	public Pager<User> listAll(String userName) {
		// TODO Auto-generated method stub
		if(userName == null || "".equals(userName)){
			return userdao.listAll();
		}else{
			return userdao.finAllByName(userName);
		}
		
	}
	public void delUse(int userId) {
		// TODO Auto-generated method stub
		User u =userdao.load(userId);
//		u.setIsDelete(1);
		userdao.update(u);
	}
	public List<User> findSYuser() {
		// TODO Auto-generated method stub
		return userdao.findSYuser();
	}
	public List<User> findBYuser() {
		// TODO Auto-generated method stub
		return userdao.findBYuser();
	}
	public List<User> findFriend(String userName, int myId) {
		// TODO Auto-generated method stub
		return null;
	}
	public User isregister(User user) {
		// TODO Auto-generated method stub
		return userdao.isregister(user);
	}
	@Override
	public Integer save2(User user) {
		return userdao.add(user).getId();
	}

}
