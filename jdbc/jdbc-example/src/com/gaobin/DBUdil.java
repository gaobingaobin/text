package com.gaobin;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUdil {
	
	//��̬����鸺���������
	private static final String driver = "com.mysql.jdbc.Driver";
	//�������ݿ��URL��ַ
	private static final String url="jdbc:mysql://localhost:3306/imocc?useUnicode=true&characterEncoding=gbk"; 
	private static final String username="root";  //���ݿ���û���
	private static final String password="gaobin";  //���ݿ������
	private static Connection conn =null;
	static{
		try {
			Class.forName(driver);
		    conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection(){
		return conn;
	}

	public static void main(String[] args) throws Exception {
		//1.�������� ��
		//Class.forName(driver);
		//conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement(); 
		ResultSet rs=stmt.executeQuery("select user_name from imooc_goddess");
		while(rs.next())
		{
			System.out.println(rs.getString("user_name"));
		}
	}
}