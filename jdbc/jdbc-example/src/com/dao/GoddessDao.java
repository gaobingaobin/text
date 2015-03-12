package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.Exception;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gaobin.DBUdil;
import com.modal.Goddess;


public class GoddessDao {
	public void addgoddess(Goddess g) throws Exception{
		Connection conn = DBUdil.getConnection();// 获取数据库连接
		String sql = "insert into imooc_goddess"+"(user_name,sex,age,birthday,email,mobile,"+
		"create_user,create_date,update_user,update_date,isdel)"+"values(?,?,?,?,?,?,?,current_date(),?,current_date(),?)";		
		 PreparedStatement ptmt=conn.prepareStatement(sql);
		 
		 ptmt.setString(1, g.getUser_name());
		 ptmt.setInt(2,g.getSex());
		 ptmt.setInt(3, g.getAge());
		 ptmt.setDate(4, new Date(g.getBirthday().getTime()) );
		 ptmt.setString(5, g.getEmail());
		 ptmt.setString(6,g.getMobile());
		 ptmt.setString(7,g.getCreate_user());
		 ptmt.setString(8,g.getUpdate_user());
		 ptmt.setInt(9, g.getIsdel());
		 ptmt.execute();
		 
	} 
	public void updateGoddess(Goddess g) throws Exception{
		Connection conn = DBUdil.getConnection();// 获取数据库连接
		
		 StringBuilder sb=new StringBuilder();
		 sb.append("update  imooc_goddess set ");
		 sb.append("(user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, "+" update_user=?,update_date=current_date(),isdel=?) ");
		 sb.append(" where id=? ");
		 PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		 System.out.println(sb.toString());
		 ptmt.setString(1, g.getUser_name());
		 ptmt.setInt(2,g.getSex());
		 ptmt.setInt(3, g.getAge());
		 ptmt.setDate(4, new Date(g.getBirthday().getTime()) );
		 ptmt.setString(5, g.getEmail());
		 ptmt.setString(6,g.getMobile());
		 ptmt.setString(7,g.getUpdate_user());
		 ptmt.setInt(8, g.getIsdel());
		 ptmt.setInt(9, g.getId());
		 ptmt.execute();
	}
	public void delGoddess(Integer id) throws Exception{
		Connection conn = DBUdil.getConnection();// 获取数据库连接
		String sql = " delete from imooc_goddess "+
		             " where id=? ";		
		 PreparedStatement ptmt=conn.prepareStatement(sql);
		 
		
		 ptmt.setInt(1, id);
		 ptmt.execute();
	}
	public List<Goddess> query(String name,String mobile) throws Exception{
		Connection conn = DBUdil.getConnection();
		List<Goddess> gs=new ArrayList<Goddess>();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from imooc_goddess ");
		sb.append(" where user_name=? and mobile=?");
		PreparedStatement  ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, name);
		ptmt.setString(2, mobile);
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		Goddess g = null;
		
		while(rs.next())
		{
			g = new Goddess();
			g.setId(rs.getInt("id"));
			 g.setAge(rs.getInt("age"));
			 g.setSex(rs.getInt("sex"));
			 g.setUser_name(rs.getString("user_name"));
			 g.setBirthday(rs.getDate("birthday"));
			 g.setEmail(rs.getString("email"));
			 g.setMobile(rs.getString("mobile"));
			 g.setCreate_date(rs.getDate("create_date"));
			 g.setCreate_user(rs.getString("create_user"));
			 g.setUpdate_date(rs.getDate("update_date"));
			 g.setUpdate_user(rs.getString("update_user"));
			 g.setIsdel(rs.getInt("isdel"));
			 gs.add(g);
			
			
		}
		return gs;
		
	}
	public List<Goddess> query() throws Exception{
		Connection conn = DBUdil.getConnection();
		
		List<Goddess> gs=new ArrayList<Goddess>();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from imooc_goddess");
		
		PreparedStatement  ptmt=conn.prepareStatement(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		Goddess g = null;
		while(rs.next())
		{
			g = new Goddess();
			g.setId(rs.getInt("id"));
			 g.setAge(rs.getInt("age"));
			 g.setSex(rs.getInt("sex"));
			 g.setUser_name(rs.getString("user_name"));
			 g.setBirthday(rs.getDate("birthday"));
			 g.setEmail(rs.getString("email"));
			 g.setMobile(rs.getString("mobile"));
			 g.setCreate_date(rs.getDate("create_date"));
			 g.setCreate_user(rs.getString("create_user"));
			 g.setUpdate_date(rs.getDate("update_date"));
			 g.setUpdate_user(rs.getString("update_user"));
			 g.setIsdel(rs.getInt("isdel"));
			 gs.add(g);
			
			
		}
		return gs;
		
	}
	public Goddess get(Integer id) throws Exception{
		Connection conn = DBUdil.getConnection();// 获取数据库连接
		String sql = " select * from imooc_goddess "+
		             " where id=? ";		
		 PreparedStatement ptmt=conn.prepareStatement(sql);
		 ptmt.setInt(1, id);
		
		 Goddess g = new Goddess();
		 ResultSet rs = ptmt.executeQuery();
		 while(rs.next()){
			
			 g.setId(rs.getInt("id"));
			 g.setAge(rs.getInt("age"));
			 g.setSex(rs.getInt("sex"));
			 g.setUser_name(rs.getString("user_name"));
			 g.setBirthday(rs.getDate("birthday"));
			 g.setEmail(rs.getString("email"));
			 g.setMobile(rs.getString("mobile"));
			 g.setCreate_date(rs.getDate("create_date"));
			 g.setCreate_user(rs.getString("create_user"));
			 g.setUpdate_date(rs.getDate("update_date"));
			 g.setUpdate_user(rs.getString("update_user"));
			 
			 
		 }
		
		return g;
	}
	


}

