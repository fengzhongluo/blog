<%@ page import="com.sparkstu.service.*,com.sparkstu.service.impl.*" %>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ArticleService  service=new ArticleServiceImpl();
	List<Object> navigation=service.getNavigationList(); 
	request.setAttribute("navigation", navigation);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>风中落叶的博客</title>
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="front/assets/i/favicon.png">
<meta name="mobile-web-app-capable" content="yes">
<link rel="icon" sizes="192x192"
	href="front/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="风中落叶的博客" />
<link rel="apple-touch-icon-precomposed"
	href="front/assets/i/app-icon72x72@2x.png">
<meta name="msapplication-TileImage"
	content="front/assets/i/app-icon72x72@2x.png">
<meta name="msapplication-TileColor" content="#0e90d2">
<link rel="stylesheet" href="front/assets/css/amazeui.min.css">
<link rel="stylesheet" href="front/assets/css/app.css">
</head>

<body id="blog">

	<!--<header class="am-g am-g-fixed blog-fixed blog-text-center blog-header">
    <div class="am-u-sm-8 am-u-sm-centered">
        <img width="200" src="http://s.amazeui.org/media/i/brand/amazeui-b.png" alt="Amaze UI Logo"/>
        <h2 class="am-hide-sm-only">中国首个开源 HTML5 跨屏前端框架</h2>
    </div>
</header>-->
	<hr>

	<!-- nav start -->
	<nav class="am-g am-g-fixed blog-fixed blog-nav">
	<button
		class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only blog-button"
		data-am-collapse="{target: '#blog-collapse'}">
		<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
	</button>

	<div class="am-collapse am-topbar-collapse" id="blog-collapse">
		<ul class="am-nav am-nav-pills am-topbar-nav">
			<li class="am-active"><a href="/">首页</a></li>
			<!--<li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          首页布局 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="lw-index.html">1. blog-index-standard</a></li>         
          <li><a href="lw-index-nosidebar.html">2. blog-index-nosidebar</a></li>
          <li><a href="lw-index-center.html">3. blog-index-layout</a></li>
          <li><a href="lw-index-noslider.html">4. blog-index-noslider</a></li>
        </ul>
      </li>-->
			<c:forEach items="${navigation}" var="navigation">
				<li><a href="${navigation.navigation_url}">${navigation.navigation_name}</a></li>
			</c:forEach>
		</ul>
		<form class="am-topbar-form am-topbar-right am-form-inline"
			role="search">
			<div class="am-form-group">
				<input type="text" class="am-form-field am-input-sm"
					placeholder="搜索">
			</div>
		</form>
	</div>
	</nav>
	<hr>
	<!-- nav end -->