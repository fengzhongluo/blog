package com.sparkstu.dao.impl;

import java.util.List;

import com.sparkstu.dao.BaseDao;
import com.sparkstu.dao.NavigationDao;

public class NavigationDaoImpl implements NavigationDao {

	@Override
	public List<Object> query(String sql) {
		BaseDao bd = new BaseDao();
        return bd.query(sql,null);
	}

}
