package com.cn.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.usermsg;

public interface UserMapper {
	public int getCount();
	public int getAllCount();
	public List<usermsg> getList();
	public List<usermsg> getUser(String name);
	public List<usermsg> getPage(int count);
	public List<usermsg> getAllPage(int count);
	public int update(@Param("o_id")int o_id,@Param("n_name")String name);
	public int delete(int id);
	public int deleterole(int id);
	public int insertfirst(int id,String name,String  gender,String  password,String  phone,String  email,String  address);
	public int insertsecond(String name,String phone,int r_id);
	public List<usermsg> tripleSearch(int id);
	public List<usermsg> login(String value,String password);
	public int updatemsg(int u_id,String password,String  phone,String email,String address);
	public int updateallmsg(int u_id,String name,String gender,String password,String  phone,String email,String address);
}
