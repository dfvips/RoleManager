package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.cn.mybatis.MybatisReader;
import com.cn.mybatis.UserMapper;

public class AddUser extends HttpServlet {

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

		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		int r_id=Integer.parseInt(request.getParameter("r_id"));
		System.out.println(name+gender+password+phone+email+address);
		SqlSession sqlSession=MybatisReader.getSession();
		int count1=sqlSession.getMapper(UserMapper.class).insertfirst(0, name, gender, password, phone, email, address);
		sqlSession.commit();
		int count2=sqlSession.getMapper(UserMapper.class).insertsecond(name, phone, r_id);
		sqlSession.commit();
		System.out.println(count1+count2);
		if(count1==1&&count2==1){
			out.print("Ok");
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
