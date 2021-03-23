package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

public class UserMsgUpdate extends HttpServlet {

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
		int u_id=Integer.parseInt(request.getParameter("u_id"));
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		SqlSession sqlSession=MybatisReader.getSession();
		int count=sqlSession.getMapper(UserMapper.class).updatemsg(u_id, password, phone, email, address);
		sqlSession.commit();
		if(count!=0){
			HttpSession session=request.getSession();			
			session.setAttribute("u_id", "");
			session.setAttribute("name", "");
			session.setAttribute("gender","");
			session.setAttribute("password", "");
			session.setAttribute("phone", "");
			session.setAttribute("email", "");
			session.setAttribute("address", "");
			session.setAttribute("r_name", "");
			session.setAttribute("r_id", "");
			session.setAttribute("authority", "");
			out.print("OK");
		}else{
			out.print("No");
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
