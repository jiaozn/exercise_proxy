package com.bbs.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler{

	private Object target;
	private static int i;
	public LogHandler(Object target) {
		super();
		this.target = target;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println((i++)+"--Invoke Successfully!Logging start...this is "+method.getName());
		method.invoke(target, args);
		System.out.println(i+"--"+method.getName()+" method has finished!");
		//System.out.println(i+"--"+"Object proxy is "+proxy.toString());//+" -and class is- "+proxy.getClass());
		return null;
	}

}
