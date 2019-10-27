package pools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class Connpools {
private String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
private String url="jdbc:sqlserver://localhost:1433;DatabaseName=school";
private String user="sa";
private String password="123456";
private LinkedList<Connection> pools;
public Connpools() {
	try {
		Class.forName(Driver);
	} catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	pools=new LinkedList<Connection>();
	for(int i=0;i<10;i++) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(url,user,password);
			pools.add(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
public Connection getConn() {
	if(pools.size()<1) {
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			pools.add(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	 Connection conn=pools.removeFirst();
	 return conn;
}
public void setConn(Connection conn) {
	pools.addLast(conn);
}
/*
 * String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
 */
//String url = "jdbc:sqlserver://localhost:1433;DatabaseName=student1";
//MySQL配置时的用户名
//String user = "sa";
//MySQL配置时的密码
//String password = "123456";
}
