<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		body{
			background:url(images/addCourse.jpg);

		} 
		p {
			text-align:center;
		}
		h1 {
			margin-top:100px;
			text-align:center;
		}
		#sub {
			margin: 20px auto; 
			width:100px;
			height:25px;
		}
		a {
			font-size:1.2em;
			color:pink;
		}
	</style>

  </head>
  <%
  	request.setCharacterEncoding("utf-8"); 
  	response.setContentType("text/html;charset=UTF-8");
   %>
  
  <body>
  	<h1>添加学生</h1>
  	<form action="servlet/AdminServlet?action=addStudent" method="post">
  		<p>姓名：<input required="required" name="sname" />
  		<p>密码：<input required="required" name="spwd" />
		<p><input id="sub" type="submit" value="添加"></p>
  	
  	</form>
  	<p><a href="adminMain.jsp">[返回主界面]</a></p>
  </body>
</html>
