<%@ page language="java" import="java.util.*,org.apache.ibatis.session.SqlSession,com.cn.mybatis.MybatisReader,com.cn.mybatis.UserMapper,entity.usermsg" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = "https://dreamfly.work"+path+"/";
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
    <title>员工信息</title>
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="user-scalable=no,width=device-width,initial-scale=1.0,maximum-scale=1.0">
	<link rel="icon" href="image/logo-s.png" type="image/x-icon"/>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/director.css">
  </head>
  
  <body>
    <div id="top">
  		<span>欢迎您，<span id="userName">${sessionScope.r_name}&nbsp;&nbsp;${sessionScope.name}</span></span>
  		<span id="logout">退出登录</span>
  	</div>
  	<div class="container" id="panel_default">
  		<h2>员工信息</h2>      
  		<div id="page"></div>
	</div>
  	<div class="container" id="panel_add">
  		<h2>新增员工</h2>      
  		 <table class="table">
		    <tbody>
		      <tr>
		        <td>用&nbsp;户&nbsp;名:</td>
		        <td><input type="text" id="name"/></td>
		      </tr>
		      <tr>
		        <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
		        <td><input type="text" id="gender"/></td>
		      </tr>
		      <tr>
		        <td>手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机:</td>
		        <td><input type="number" id="phone" value=""/></td>
		      </tr>
		      <tr>
		        <td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</td>
		        <td><input type="email" id="email" value="" /></td>
		      </tr>
		      <tr>
		        <td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:</td>
		        <td><input type="text" id="address" value="" /></td>
		      </tr>
		      <tr>
		        <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
		        <td><input type="password" id="password" /></td>
		      </tr>
		      <tr>
		        <td>确认密码:</td>
		        <td><input type="password" id="repassword"/></td>
		      </tr>
		      <tr>
		        <td colspan="2"><div id="td_bottom"><button type="button" class="btn btn-default" id="btn_add">确定</button><button type="button" class="btn btn-default" id="cancle">取消</button></div></td>
		      </tr>
		    </tbody>
		 </table>
	</div>
	<div id="footer"><p>Copyright © 2019 DreamFly.All Rights Reserved.</p><p>梦丶随心飞&nbsp;&nbsp;版权所有</p></div>
	<script src="js/director.js"></script>
  </body>
</html>
