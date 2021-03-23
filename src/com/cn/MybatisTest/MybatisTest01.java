package com.cn.MybatisTest;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.cn.mybatis.MybatisReader;
import com.cn.mybatis.UserMapper;

import entity.usermsg;

public class MybatisTest01 {

	@Test
	public void test() {

		SqlSession sqlSession=MybatisReader.getSession();
//		int count=sqlSession.getMapper(UserMapper.class).getCount();
//		System.out.println("用户数量:"+count);
		
//		List<usermsg> all=sqlSession.getMapper(UserMapper.class).getList();
//		System.out.println("用户名:"+all.get(0).getName());
		
//		List<usermsg> user=sqlSession.getMapper(UserMapper.class).getUser("张三");
//		System.out.println("用户名:"+user.get(0).getName()+";ID:"+user.get(0).getId());
		
		List<usermsg> page=sqlSession.getMapper(UserMapper.class).getPage(0);
		System.out.println("用户名:"+page.get(0).getName());
		
//		int count=sqlSession.getMapper(UserMapper.class).update(2,"张三");
//		sqlSession.commit();
//		System.out.println("update数量为"+count);
		
//		int count=sqlSession.getMapper(UserMapper.class).delete(4);
//		sqlSession.commit();
//		System.out.println("delete数量为"+count);
		
//		int count=sqlSession.getMapper(UserMapper.class).insert(0,"李华", "女", "chen123456","15875457485","420443292@qq.com","北京北京",3);	
//		sqlSession.commit();
//		System.out.println("insert数量为"+count);
		
//		int a=6;
//		List<usermsg> user=sqlSession.getMapper(UserMapper.class).tripleSearch(a);
//		System.out.println("用户名:"+user.get(0).getName()+","+user.get(0).getId()+","+user.get(0).getR_name()+","+user.get(0).getAuthority()+","+user.get(0).getAddress()+","+user.get(0).getEmail()+","+user.get(0).getGender());
//		List<usermsg> user=sqlSession.getMapper(UserMapper.class).login("liming", "chen123");
//		System.out.println("用户名:"+user.get(0).getName()+","+user.get(0).getId());
		sqlSession.close();
	}

}
