package com.sparkstu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.sparkstu.dao.ArticleDao;
import com.sparkstu.dao.BaseDao;
import com.sparkstu.entity.Article;



public class ArticleDaoImpl implements ArticleDao {
	private PreparedStatement ppst = null;
	public List<Object> query(String sql,Object[] params){
		BaseDao bd = new BaseDao();
        return bd.query(sql, params);
	}
	
	public int insert(String sql,Object[] params){		 
		 BaseDao bd = new BaseDao();
	     return bd.update(sql, params);
	}
	

}
