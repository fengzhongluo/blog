package com.sparkstu.service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.sparkstu.entity.Article;

public interface ArticleService {
	List<Object> getArticleList();//获取列表
	List<Object> getNavigationList();//获取导航列表
	Article getArticle(Object[] params) throws IllegalAccessException, InstantiationException, InvocationTargetException, IntrospectionException;//获取文章详细
	int addArticle(Object[] params);
	int editArticle(Object[] params);
}
