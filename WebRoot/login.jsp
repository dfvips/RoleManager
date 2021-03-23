<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = "https://dreamfly.work"+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>迅达员工管理登录系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="user-scalable=no,width=device-width,initial-scale=1.0,maximum-scale=1.0">
	<link rel="icon" href="image/logo-s.png" type="image/x-icon"/>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/login.css">

  </head>
  
  <body>
<div id="top"><h2>迅达员工管理登录系统</h2></div>
<form role="form" id="form" onsubmit="return loginAction()">
	<div class="form-group">
		<h2 id="login_h2">用户登录<span id="login_tip">User Login</span></h2>
		<input type="text" class="form-control" id="name" 
			   placeholder="请输入用户名" required>
   		<input type="password" class="form-control" id="password" 
			   placeholder="请输入密码" required>
	</div>
	<button type="submit" class="btn btn-default">登录</button>
</form>
<div id="footer"><p>Copyright © 2019 DreamFly.All Rights Reserved.</p><p>梦丶随心飞&nbsp;&nbsp;版权所有</p></div>
	<script src="js/login.js"></script>
  </body>
</html>
