package com.sparkstu.service.impl;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.sparkstu.dao.UserDao;
import com.sparkstu.dao.impl.UserDaoImpl;
import com.sparkstu.entity.Article;
import com.sparkstu.entity.User;
import com.sparkstu.service.LoginService;
import com.sparkstu.utils.BeanUtils;

public class LoginServiceImpl implements LoginService {

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User verificationUser(Object[] params) throws InstantiationException, InvocationTargetException, IntrospectionException {
		// TODO Auto-generated method stub
		String sql="select * from user where username=? and password=? ";
		List<Object> list=userDao.query(sql, params);
		
		if(!list.isEmpty()) {
			Map< String , Object> map=(Map<String, Object>)list.get(0) ;
			return (User)BeanUtils.convertMap(User.class,map);
		}else {
			
			return null;
		}
	}

}
