<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% 

		String path = request.getContextPath(); 
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
		String name = request.getParameter("name");//用request得到 
		if("测试2".equals(name)){
			String str="10000";
			out.print(str);     //输出null
			
		}else if("测试".equals(name)){
			String str="成功";
			out.print(str); 
			
		}
		

			//out.write(str); 
%>