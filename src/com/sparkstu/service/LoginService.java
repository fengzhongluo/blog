package com.sparkstu.service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import com.sparkstu.entity.User;


/**
 * @author zhangwei
 * @date 2018年12月6日
 */
public interface LoginService {
	

	/**
	 * @param username 用户名
	 * @param password MD5加密后的密码
	 * @return
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws InstantiationException 
	 */
	public User verificationUser(Object[] params) throws InstantiationException, InvocationTargetException, IntrospectionException ; 
}
