<%@ page import="com.sparkstu.entity.Article"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/front/heard.jsp"></jsp:include>

<!-- banner start -->
<!-- <div class="am-g am-g-fixed blog-fixed am-u-sm-centered blog-article-margin">
    <div data-am-widget="slider" class="am-slider am-slider-b1" data-am-slider='{&quot;controlNav&quot;:false}' >
    <ul class="am-slides">
      <li>
            <img src="front/assets/i/b1.jpg">
            <div class="blog-slider-desc am-slider-desc ">
                <div class="blog-text-center blog-slider-con">
                    <span><a href="" class="blog-color">Article &nbsp;</a></span>               
                    <h1 class="blog-h-margin"><a href="">总在思考一句积极的话</a></h1>
                    <p>那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。
                    </p>
                    <span class="blog-bor">2015/10/9</span>
                    <br><br><br><br><br><br><br>                
                </div>
            </div>
      </li>
      <li>
            <img src="front/assets/i/b2.jpg">
            <div class="am-slider-desc blog-slider-desc">
                <div class="blog-text-center blog-slider-con">
                    <span><a href="" class="blog-color">Article &nbsp;</a></span>               
                    <h1 class="blog-h-margin"><a href="">总在思考一句积极的话</a></h1>
                    <p>那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。
                    </p>
                    <span>2015/10/9</span>                
                </div>
            </div>
      </li>
      <li>
            <img src="front/assets/i/b3.jpg">
            <div class="am-slider-desc blog-slider-desc">
                <div class="blog-text-center blog-slider-con">
                    <span><a href="" class="blog-color">Article &nbsp;</a></span>               
                    <h1 class="blog-h-margin"><a href="">总在思考一句积极的话</a></h1>
                    <p>那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。
                    </p>
                    <span>2015/10/9</span>                
                </div>
            </div>
      </li>
      <li>
            <img src="front/assets/i/b2.jpg">
            <div class="am-slider-desc blog-slider-desc">
                <div class="blog-text-center blog-slider-con">
                    <span><a href="" class="blog-color">Article &nbsp;</a></span>               
                    <h1 class="blog-h-margin"><a href="">总在思考一句积极的话</a></h1>
                    <p>那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。
                    </p>
                    <span>2015/10/9</span>                
                </div>
            </div>
      </li>
    </ul>
    </div>
</div> -->
<!-- banner end -->

<!-- content srart -->
<div class="am-g am-g-fixed blog-fixed">
    <div class="am-u-md-8 am-u-sm-6">

		<c:forEach items="${list}" var="list">
	        <article class="am-g blog-entry-article">
	            <div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
	                <img src="image?id=${list.coverURL}" alt="" class="am-u-sm-12">
	            </div>
	            <div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
	                <span><a href="" class="blog-color">article&nbsp;</a></span>
	                <span>${list.author}&nbsp;</span>
	                <span>${list.publishTime}</span>
	                <h1><a href="<%=request.getContextPath() %>/article?method=contents&id=${list.id}">${list.title}</a></h1>
	                <p>${list.summary}</p>
	                <p><a href="" class="blog-continue">continue</a></p>
	            </div>
	        </article>
		</c:forEach>

        <ul class="am-pagination">
		  <li class="am-pagination-prev"><a href="">&laquo; Prev</a></li>
		  <li class="am-pagination-next"><a href="">Next &raquo;</a></li>
		</ul>
    </div>
	<%-- <jsp:include page="/WEB-INF/front/content_right.jsp"></jsp:include> --%>
    
</div>
<!-- content end -->



 +
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="front/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="front/assets/js/amazeui.min.js"></script>
</body>
</html>