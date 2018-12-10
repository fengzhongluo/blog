package com.sparkstu.dao;

import java.util.List;

public interface UserDao {
	
	public List<Object> query(String sql,Object[] params);

}
