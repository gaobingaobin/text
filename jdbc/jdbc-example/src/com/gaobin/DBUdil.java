package com.gaobin;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUdil {
	
	//静态代码块负责加载驱动
	private static final String driver = "com.mysql.jdbc.Driver";
	//链接数据库的URL地址
	private static final String url="jdbc:mysql://localhost:3306/imocc?useUnicode=true&characterEncoding=gbk"; 
	private static final String username="root";  //数据库的用户名
	private static final String password="gaobin";  //数据库的密码
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
		//1.加载驱动 ！
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