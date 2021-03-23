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
//		System.out.println("�û�����:"+count);
		
//		List<usermsg> all=sqlSession.getMapper(UserMapper.class).getList();
//		System.out.println("�û���:"+all.get(0).getName());
		
//		List<usermsg> user=sqlSession.getMapper(UserMapper.class).getUser("����");
//		System.out.println("�û���:"+user.get(0).getName()+";ID:"+user.get(0).getId());
		
		List<usermsg> page=sqlSession.getMapper(UserMapper.class).getPage(0);
		System.out.println("�û���:"+page.get(0).getName());
		
//		int count=sqlSession.getMapper(UserMapper.class).update(2,"����");
//		sqlSession.commit();
//		System.out.println("update����Ϊ"+count);
		
//		int count=sqlSession.getMapper(UserMapper.class).delete(4);
//		sqlSession.commit();
//		System.out.println("delete����Ϊ"+count);
		
//		int count=sqlSession.getMapper(UserMapper.class).insert(0,"�", "Ů", "chen123456","15875457485","420443292@qq.com","��������",3);	
//		sqlSession.commit();
//		System.out.println("insert����Ϊ"+count);
		
//		int a=6;
//		List<usermsg> user=sqlSession.getMapper(UserMapper.class).tripleSearch(a);
//		System.out.println("�û���:"+user.get(0).getName()+","+user.get(0).getId()+","+user.get(0).getR_name()+","+user.get(0).getAuthority()+","+user.get(0).getAddress()+","+user.get(0).getEmail()+","+user.get(0).getGender());
//		List<usermsg> user=sqlSession.getMapper(UserMapper.class).login("liming", "chen123");
//		System.out.println("�û���:"+user.get(0).getName()+","+user.get(0).getId());
		sqlSession.close();
	}

}
