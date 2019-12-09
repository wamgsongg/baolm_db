package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	private static final String jdbcUrl="jdbc:mysql://cdb-pllfd5fy.bj.tencentcdb.com:10146/blm?useSSL=false&serverTimezone=UTC";
	private static final String dbUser="root";
	private static final String dbPwd="wangsong990315";

	
	static
	{
		//加载驱动
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws java.sql.SQLException{
		return java.sql.DriverManager.getConnection(jdbcUrl,dbUser,dbPwd);
	}
	public static void closeConn(Connection conn) {
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭连接失败！");
                e.printStackTrace();
            }
        }
    }
	



}
