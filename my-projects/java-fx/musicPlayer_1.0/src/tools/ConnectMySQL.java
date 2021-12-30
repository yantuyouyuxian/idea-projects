/**
 * 
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Z H
 *
 */
public class ConnectMySQL {

	/**
	 * @param args
	 */
	private static final String URL = "jdbc:mysql://localhost:3306/db_musicplayer";
	private static final String USER = "root";
	private static final String PASSWORD = "2242757980";

	protected static Statement state = null;
	protected static ResultSet rs = null;
	protected static Connection conn = null;

	
	
	public static synchronized Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("连接成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接失败！");
		}
		return conn;
	}
	
	/**
	 * 执行insert,update,delete
	 * @param sql
	 * @return
	 */
	public static int executeUpdate(String sql) {
		int result = 0;
		try {
			state = getConnection().createStatement();
			result = state.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 执行select
	 * @param sql
	 * @return
	 */
	public static ResultSet executeQuery(String sql) {
		try {
			state=getConnection().createStatement();
			rs=state.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 返回动态sql语句
	 * @param sql
	 * @return
	 */
	public static PreparedStatement executePreparedStatement(String sql) {
		PreparedStatement ps=null;
		try {
			ps=getConnection().prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	/**
	 * 关闭连接
	 * @param sql
	 * @return
	 */
	public static void close() {
		try {
			if(rs!=null)
				rs.close();
			if(state!=null)
				state.close();
			if(conn!=null)
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("连接已断开！");
		}
	}

}
