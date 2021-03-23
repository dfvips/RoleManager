package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.cn.mybatis.MybatisReader;
import com.cn.mybatis.UserMapper;

import entity.usermsg;

public class AdminDelete extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding ("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int count=0;
		//String username=URLDecoder.decode(request.getParameter("username"),"utf-8");
		if(request.getParameter("count")!=null){
			count=Integer.parseInt(request.getParameter("count"));
		}
		int all=0;
		int page=0;
		HttpSession session = request.getSession();
		if(session.getAttribute("all")!=null){
			all=Integer.parseInt((String) session.getAttribute("all"));
		}else{
			SqlSession sqlSession=MybatisReader.getSession();
			all=sqlSession.getMapper(UserMapper.class).getAllCount();
			sqlSession.close();
		}
		page=all%3 == 0 ? (all/3) : ((all/3)+1);
		List<usermsg> list=new ArrayList<usermsg>();
		SqlSession sqlSession=MybatisReader.getSession();
		list=sqlSession.getMapper(UserMapper.class).getAllPage(count*3);
		sqlSession.close();
		if(list.size()!=0){
			out.println("<table>");
			out.println("<th>用户名</th><th>性别</th><th>手机</th><th>邮箱</th><th>地址</th><th>职位</th>");
		for(int i = 0 ; i < list.size() ; i++) {
			  out.println("<tr id='delete_msg'>");
			  out.println("<td id='"+list.get(i).getId()+"'>"+list.get(i).getName()+"</td>");
			  out.println("<td>"+list.get(i).getGender()+"</td>");
			  out.println("<td>"+list.get(i).getPhone()+"</td>");
			  out.println("<td>"+list.get(i).getEmail()+"</td>");
			  out.println("<td>"+list.get(i).getAddress()+"</td>");
			  out.println("<td>"+list.get(i).getR_name()+"</td>");
			  out.println("<tr>");
			}
		int pre=0;
		int last=0;
		
		if(count>=(page-1)){
			pre=(count-1);
			last=(page-1);
		}else if((count-1)<0){
			pre=0;
			last=count+1;
		}else{
			pre=count-1;
			last=count+1;
		}
		 out.println("<tr id='tr_bottom'><td colspan='6'><a id="+pre+">上一页</a>&nbsp;&nbsp;");
		 for(int i=0;i<page;i++){
			 if(i==count){
				 out.println("<span style='color:red'>"+(i+1)+"</span>");
			 }else{
				 out.println("<span >"+(i+1)+"</span>");
			 }
		 }
		 out.println("&nbsp;&nbsp;<a id="+last+">下一页</a></td></tr");
		 out.println("<tr>");
		 out.println("<td colspan='6'><button type='submit' class='btn btn-default' id='btn_delete'>选择删除员工</button><button type='submit' class='btn btn-default' id='delete_cancle'>取消</button></td>");
		 out.println("<tr>");
		 out.println("</table>");
		}
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
