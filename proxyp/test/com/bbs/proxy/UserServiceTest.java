package com.bbs.proxy;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class UserServiceTest {
	//@Test
	public void testUserDAOImpl() {
		new UserDAOImpl().delete();
		
	}
	
	
	
	//@Test
	public void testAdd() {
		User user=new User();
		user.setId(1);
		user.setName("user1");
		
		UserService us=new UserService();
		us.add(user);
		us.delete();
		
	}
	
	@Test
	public void testAddviaProxy()  {
		User user=new User();
		user.setId(1);
		user.setName("user1");
		
		Object target;
		target=new UserDAOImpl();
		
		
		InvocationHandler h=new LogHandler(target);
		UserDAO userDAO=(UserDAO) Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{UserDAO.class}, h);
		
		
		//h.invoke(target, target.getClass().getMethod("add", new Class[]{user.getClass()}), new Object[]{User.class});
		userDAO.delete();
	}
	
	

}
