package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql_server {
		public static void main(String[] args) {
			//声明Connection对象
			Connection con;
			//驱动程序名com.mysql.cj.jdbc.Driver   com.mysql.jdbc.Driver
			//String driver = "com.mysql.cj.jdbc.Driver";
			//URL指向要访问的数据库名student  
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=student1";
			//MySQL配置时的用户名
			String user = "sa";
			//MySQL配置时的密码
			String password = "123456";
			//遍历查询结果集
			try {
			//加载驱动程序
			Class.forName(driver);
			//1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url,user,password);
			if(!con.isClosed())
			System.out.println("Succeeded connecting to the Database!");
			//2.创建statement类对象，用来执行SQL语句！！
			con.close();
			} catch(ClassNotFoundException e) { 
			//数据库驱动类异常处理
			System.out.println("Sorry,can't find the Driver!"); 
			e.printStackTrace(); 
			} catch(SQLException e) {
			//数据库连接失败异常处理
			e.printStackTrace(); 
			}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		}
}
