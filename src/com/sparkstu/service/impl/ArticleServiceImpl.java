package com.sparkstu.service.impl;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.sparkstu.dao.ArticleDao;
import com.sparkstu.dao.impl.ArticleDaoImpl;
import com.sparkstu.entity.Article;
import com.sparkstu.service.ArticleService;
import com.sparkstu.utils.BeanUtils;

public class ArticleServiceImpl implements ArticleService {
	
	ArticleDao articleDao = new ArticleDaoImpl();

	@Override
	public List<Object> getArticleList() {

		String sql = "select * from blog order by publishTime desc";
		return articleDao.query(sql, null);
	}

	@Override
	public Article getArticle(Object[] params) throws IllegalAccessException, InstantiationException, InvocationTargetException, IntrospectionException {
		String sql="select * from blog where id=? ";
		List<Object> list=articleDao.query(sql, params);
		
		if(!list.isEmpty()) {
			Map< String , Object> map=(Map<String, Object>)list.get(0) ;
			return (Article)BeanUtils.convertMap(Article.class,map);
		}else {
			
			return null;
		}
		
	}

	@Override
	public int addArticle(Object[] params) {
		String sql ="insert into blog(id,title,author,summary,content,publishTime,url,html,tags) values(uuid(),?,?,?,?,?,?,?,?)";
        return articleDao.insert(sql, params);
	}
	@Override
	public int editArticle(Object[] params) {
		String sql ="update blog set title= ?,author=?,summary=?,content=?,publishTime=?,url=?,html=?,tags=? where id=?";
        return articleDao.insert(sql, params);
	}
	

}
