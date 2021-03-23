package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.cn.mybatis.MybatisReader;
import com.cn.mybatis.UserMapper;

import entity.usermsg;

/**
 * Servlet Filter implementation class Chaper8_1Filter01
 */
@WebFilter("/director.jsp")
public class MyFilter01 implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter01() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding ("UTF-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session=req.getSession();
		int u_id=0;
		if(session.getAttribute("u_id")!=null){
			u_id=Integer.parseInt(session.getAttribute("u_id").toString());
		SqlSession sqlSession=MybatisReader.getSession();
		List<usermsg> msg=sqlSession.getMapper(UserMapper.class).tripleSearch(u_id);
		sqlSession.commit();
		if(msg!=null){
			if(msg.get(0).getAuthority().equals("All")||msg.get(0).getAuthority().equals("AddSearch_all")){
				chain.doFilter(request, response);
			}else{
				out.print("<h2 Style='text-align:center;margin:0 auto;color:red;'>无权访问！</h2>");
				res.setHeader("Refresh", "2;url=login.jsp");
			}
		}
		}else{
			out.print("<h2 Style='text-align:center;margin:0 auto;color:red;'>无权访问！</h2>");
			res.setHeader("Refresh", "2;url=login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}