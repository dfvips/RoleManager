<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = "https://dreamfly.work"+path+"/";
// String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%
    	if(session.getAttribute("u_id")==""||session.getAttribute("u_id")==null){
    		response.sendRedirect("login.jsp");
    	}
     %>
    <title>个人信息</title>
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="user-scalable=no,width=device-width,initial-scale=1.0,maximum-scale=1.0">
	<link rel="icon" href="image/logo-s.png" type="image/x-icon"/>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/user.css">
  </head>
  
  <body>
  	<div id="top">
  		<span>欢迎您，<span id="userName">${sessionScope.name}</span></span>
  		<span id="logout">退出登录</span>
  	</div>
  	<div class="container">
  <h2>个人信息</h2>      
  <table class="table">
    <tbody>
      <tr>
        <td>用&nbsp;户&nbsp;名:</td>
        <td id="${sessionScope.u_id}" class="user">${sessionScope.name}</td>
      </tr>
      <tr>
        <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
        <td>${sessionScope.gender}</td>
      </tr>
      <tr>
        <td>手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机:</td>
        <td>${sessionScope.phone}</td>
      </tr>
      <tr>
        <td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</td>
        <td>${sessionScope.email}</td>
      </tr>
      <tr>
        <td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:</td>
        <td>${sessionScope.address}</td>
      </tr>
      <tr>
        <td>用户类型:</td>
        <td>${sessionScope.r_name}</td>
      </tr>
      <tr>
        <td colspan="2"><button type="submit" class="btn btn-default">修改信息</button></td>
      </tr>
    </tbody>
  </table>
</div>
<div id="footer"><p>Copyright © 2019 DreamFly.All Rights Reserved.</p><p>梦丶随心飞&nbsp;&nbsp;版权所有</p></div>
	<script src="js/user.js"></script>
  </body>
</html>
