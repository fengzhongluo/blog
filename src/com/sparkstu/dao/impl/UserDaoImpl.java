package com.sparkstu.dao.impl;

import java.util.List;

import com.sparkstu.dao.BaseDao;
import com.sparkstu.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public List<Object> query(String sql,Object[] params) {
		BaseDao bd = new BaseDao();
        return bd.query(sql, params);
	}

}
