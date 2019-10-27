package pools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Boootstrap {
	private static String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url="jdbc:sqlserver://localhost:1433;DatabaseName=school";
	private static String user="sa";
	private static String password="123456";
public static void main(String []args) {
		 Long time1=System.currentTimeMillis(); 
		 Connpools pools=new Connpools();
		 for(int i=0;i<5000;i++) { 
			 Connection conn=pools.getConn();
		     pools.setConn(conn); 
		 } 
		 Long time2=System.currentTimeMillis();
		  System.out.println(time2-time1);
		 
	 Long time3=System.currentTimeMillis();
	 for(int i=0;i<5000;i++) {
	 try {
			Class.forName(Driver);
			//1.getConnection()方法，连接MySQL数据库！！
			Connection con = DriverManager.getConnection(url,user,password);
			if(!con.isClosed())
				con.close();
			} 
			catch(ClassNotFoundException e) {
			e.printStackTrace(); 
			}
			catch(SQLException e) {
			e.printStackTrace(); 
			}
		}
	 Long time4=System.currentTimeMillis();
	 System.out.println(time4-time3);
}	 
}

