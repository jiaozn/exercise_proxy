package com.bbs.proxy;

public class UserService {
	UserDAO userDAO=new UserDAOImpl();
	public void add(User user){
		userDAO.save(user);
	}
	public void delete(){
		userDAO.delete();
	}
}
