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
			color:pink;
		}
		span {
			color: blue;
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
			color:pink;
			font-size:1.2em;
		}
	</style>

  </head>
  <%
  	request.setCharacterEncoding("utf-8"); 
  	response.setContentType("text/html;charset=UTF-8");
   %>
  
  <body>
  	<h1>添加课程</h1>
  	<form action="servlet/AdminServlet?action=addCourse" method="post">
  		<p><span>课程名：</span><input required="required" name="cname" />
			学&nbsp;分：
			<select name="credit">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select>
		</p>
		<p><input id="sub" type="submit" value="添加"></p>
  	</form>
  	<p><a href="adminMain.jsp">[返回主界面]</a></p>
  </body>
</html>
