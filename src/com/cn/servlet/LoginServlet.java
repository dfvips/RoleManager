package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cn.mybatis.MybatisReader;
import com.cn.mybatis.UserMapper;

import entity.usermsg;
import net.sf.json.JSONArray;

public class LoginServlet extends HttpServlet {

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
		String value=null;
		String password=null;
		SqlSession sqlSession=MybatisReader.getSession();
		if(request.getParameter("username")!=null&&request.getParameter("password")!=null){
			value=request.getParameter("username");
			password=request.getParameter("password");
			List<usermsg> user=sqlSession.getMapper(UserMapper.class).login(value, password);
			sqlSession.commit();
			if(user.size()!=0){
				int u_id=user.get(0).getId();
				List<usermsg> msg=sqlSession.getMapper(UserMapper.class).tripleSearch(u_id);
				sqlSession.commit();
				if(msg!=null){
					HttpSession session=request.getSession();						
					usermsg loginuser=msg.get(0);
					session.setAttribute("u_id", loginuser.getId());
					session.setAttribute("name", loginuser.getName());
					session.setAttribute("gender", loginuser.getGender());
					session.setAttribute("password", loginuser.getPassword());
					session.setAttribute("phone", loginuser.getPhone());
					session.setAttribute("email", loginuser.getEmail());
					session.setAttribute("address", loginuser.getAddress());
					session.setAttribute("r_name", loginuser.getR_name());
					session.setAttribute("r_id", loginuser.getR_id());
					session.setAttribute("authority", loginuser.getAuthority());
					if(msg.get(0).getAuthority().equals("All")){
						 out.print("admin.jsp");
					}else if(msg.get(0).getAuthority().equals("UpdateSearch_self")){
						
						out.print("user.jsp");
					}else if(msg.get(0).getAuthority().equals("AddSearch_all")){
						out.print("director.jsp");
					}
			       
				}
				sqlSession.close();
			}else{
				out.print("No");
				sqlSession.close();
			}
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
