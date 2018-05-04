package com.sparkstu.dao;

import java.sql.ResultSet;
import java.util.List;

import com.sparkstu.entity.Article;

public interface ArticleDao {
	
	List<Object> query(String sql,Object[] params);

	int insert(String sql, Object[] params);
	

}
