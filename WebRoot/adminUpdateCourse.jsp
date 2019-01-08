<%@ page language="java" import="java.util.*,com.wenr.model.Course" contentType="text/html; charset=utf-8"%>
<jsp:useBean id="courseDao" class="com.wenr.dao.CourseDao" />
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
		body {
			background:url(images/updateCourse.jpg);
		}
		form {
			text-align:center;
			margin:30px auto;
			width:400px;
			border:1px solid #000;
		}
	</style> 

  </head>
  
  <body>
  	<%
  		request.setCharacterEncoding("utf-8"); 
  		response.setContentType("text/html;charset=UTF-8");
  		int cid = Integer.parseInt(request.getParameter("cid"));
  		Course course = courseDao.getCourseById(cid);
  	 %>
  	<form action="servlet/AdminServlet?action=update&cid=<%=cid %>" method="post">
  		<p><label>课程号： <%=cid %></label></p>
  		<p><label>课程名：</label>
  		<input type="text" name="cname" value="<%=course.getCname() %>"></p>
  		<p><label>学&nbsp;分：</label>
  		<select name="credit" >
				<option <%=(1==course.getCredit())?"selected":"" %> value="1">1</option>
				<option <%=(2==course.getCredit())?"selected":"" %> value="2">2</option>
				<option <%=(3==course.getCredit())?"selected":"" %> value="3">3</option>
				<option <%=(4==course.getCredit())?"selected":"" %> value="4">4</option>
				<option <%=(5==course.getCredit())?"selected":"" %> value="5">5</option>
				<option <%=(6==course.getCredit())?"selected":"" %> value="6">6</option>
				<option <%=(7==course.getCredit())?"selected":"" %> value="7">7</option>
				<option <%=(8==course.getCredit())?"selected":"" %> value="8">8</option>
				<option <%=(9==course.getCredit())?"selected":"" %> value="9">9</option>
				<option <%=(10==course.getCredit())?"selected":"" %> value="10">10</option>
			</select>
  		</p>
  		<p><input type="submit" value="更新"></p>
  	</form>
     
  </body>
</html>
