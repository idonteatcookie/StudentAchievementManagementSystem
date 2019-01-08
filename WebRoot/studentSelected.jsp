<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="com.wenr.model.*,com.wenr.dao.StudentDao" %>
<jsp:useBean id="studentDao" class="com.wenr.dao.StudentDao" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生登录</title>
    
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
			background: url(images/studentSelected.jpg);
		}
		table {
			border-collapse:collapse;
			margin:0px auto;
			text-align:center;
			font-size:1.2em;
		}
		h1 {
			text-align:center;
		}

		p {
			font-size:1.2em;
			text-align:center;
		}
	
	</style>

  </head>
  
  <body>
    	
  	<h1>已选课程</h1>
  
  	<table border="1px" cellspacing="0px">
  		<tr>
  			<td>课程号</td>
  			<td>课程名</td>
  			<td>学分</td>
  			<td>成绩</td>
  			<td>操作</td>
  		</tr>
  		
  		<%
  			String[] color = {"yellow", "green"};
  			Student student = (Student)session.getAttribute("student");
  			ArrayList<Course> list = studentDao.getSelectedCourse(student);
  			for (int i = 0; i < list.size(); i++) {
  				Course course = list.get(i);
  		%>
  			<tr bgcolor="<%=color[i%2] %>" >
  				<td><%=course.getCid() %></td>
	  			<td><%=course.getCname() %></td>
	  			<td><%=course.getCredit() %></td>
	  			<!-- 如何把为null的成绩不显示出来？？ 窝偷偷把默认成绩改成了-1 感觉不太好-- -->
	  			<td><%=course.getScore()<0?"":course.getScore() %></td>
	  			<td><a href="servlet/StudentServlet?action=delete&cid=<%=course.getCid() %>">删除</a></td>
  			</tr>
  			
  		<%
  			}
  		%>
  		
  	</table>
  	<p><a href="studentMain.jsp">[返回主界面]</a></p>
  	
  </body>
</html>