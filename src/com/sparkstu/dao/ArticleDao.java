package com.sparkstu.dao;

import java.util.List;

public interface ArticleDao {
	
	List<Object> query(String sql,Object[] params);

	int insert(String sql, Object[] params);
	
}
