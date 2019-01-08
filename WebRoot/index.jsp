<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学生成绩管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->
<style type="text/css">
p,input,label,select,button{
	font-size:20px;
}
html{   
    width: 100%;   
    height: 100%;   
    overflow: hidden;
    font-style: sans-serif;
}
body{   
    width: 100%;
    height: 100%;
    margin: 0;
    background: #00FFCC url(images/login.jpg); 
}
#login {
	width:400px;
	margin:100px auto;
/*	color:red;
 	border:1px solid #F00; */
	background-color:#666666;
	padding:10px 0;
}
h1 {
	padding:20px 0px 0 0;
	text-align: center;
	color:#FFFF00;
}
label {
	color:#FFFF00;
}
.input {
	border:0px;
	width:100%;
	border-radius:3px;
	padding:5px;
}
button {
	width:100%;
	border:0;
	border-radius: 5px;
	padding: 5px;
}
p {
	padding: 0px 30px 5px 30px;
}
</style>

</head>

  <%
  	request.setCharacterEncoding("utf-8");
  	String inumber = "";
  	String password = "";
  	Cookie[] cookies = request.getCookies();
  	if (cookies != null && cookies.length > 0) {
  		for (Cookie c: cookies) {
  			if ("inumber".equals(c.getName())) {
  				inumber = c.getValue();
  			}
  			if ("password".equals(c.getName())) {
  				password = c.getValue();
  			}
  		}
  	}
   %>

<body>
	<div id="login">
		<h1>欢迎登录</h1>
		<form action="servlet/LoginServlet?action=login" method="post">
			<!-- required表示该字段必填 -->
			<p><input class="input" type="text" placeholder="账号" required="required" name="inumber" value="<%=inumber %>" /></p>
			<p><input class="input" type="password" placeholder="密码" required="required" name="password" value="<%=password%>"/></p>
			<p><label>选择登录身份：</label>
				<select name="identity">
					<option value="student">学生</option>
					<option value="teacher">教师</option>
					<option value="admin">管理员</option>
				</select>
			</p>
			<p><input type="checkbox" name="isUseCookie" checked="checked" />记住密码(非本人电脑请勿勾选)</p>
			<p id="button"><button type="submit">登录</button></p>
		</form>
	</div>
</body>
</html>
