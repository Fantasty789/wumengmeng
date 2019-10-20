package send_sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class Printf {
	public static void main(String[] args) {
		//声明Connection对象
		Connection con;
		//驱动程序名com.mysql.cj.jdbc.Driver   com.mysql.jdbc.Driver
		String driver = "com.mysql.cj.jdbc.Driver";
		//URL指向要访问的数据库名student  
		String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
		//MySQL配置时的用户名
		String user = "root";
		//MySQL配置时的密码
		String password = "ws15897782192";
		//遍历查询结果集
		try {
		//加载驱动程序
		Class.forName(driver);
		//1.getConnection()方法，连接MySQL数据库！！
		con = DriverManager.getConnection(url,user,password);
		if(!con.isClosed())
		System.out.println("Succeeded connecting to the Database!");
		//2.创建statement类对象，用来执行SQL语句！！
		Statement statement = con.createStatement();
		//要执行的SQL语句
		String sql = "select * from stu";
		//3.ResultSet类，用来存放获取的结果集！！
		ResultSet rs = statement.executeQuery(sql);
		System.out.println("-----------------");
		System.out.println("执行结果如下所示:"); 
		System.out.println("-----------------"); 
		System.out.println(" 学号" + "\t" + " 姓名"); 
		System.out.println("-----------------"); 

		String name = null;
		String num = null;
		while(rs.next()){
		//获取name这列数据
		name = rs.getString("name");
		//获取num这列数据
		num = rs.getString("num");
		//首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
		//然后使用GB2312字符集解码指定的字节数组。
		name = new String(name.getBytes("utf8"),"gb2312");
		//输出结果
		System.out.println(num + "\t" + name);
		}
		rs.close();
		con.close();
		} catch(ClassNotFoundException e) { 
		//数据库驱动类异常处理
		System.out.println("Sorry,can`t find the Driver!"); 
		e.printStackTrace(); 
		} catch(SQLException e) {
		//数据库连接失败异常处理
		e.printStackTrace(); 
		}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		}
		finally{
		System.out.println("数据库数据成功获取！！");
		}
		}
}
