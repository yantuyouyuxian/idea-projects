package lesson02.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    protected static Statement state = null;
    protected static PreparedStatement ps = null;
    protected static ResultSet rs = null;
    protected static Connection conn = null;

    static {
        try {
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            Class.forName(driver);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnection() {

        if(conn==null){
            try {
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("连接成功！");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("连接失败！");
            }
        }
        return conn;
    }

    /**
     * 执行insert,update,delete
     *
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
     *
     * @param sql
     * @return
     */
    public static ResultSet executeQuery(String sql) {
        try {
            state = getConnection().createStatement();
            rs = state.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 返回动态sql语句
     *
     * @param sql
     * @return
     */
    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            ps = getConnection().prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ps;
    }

    /**
     * 关闭连接
     *
     * @param
     * @return
     */
    public static void close() {
        try {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (state != null)
                state.close();
            if (conn != null)
                conn.close();
            System.out.println("成功关闭！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("成功失败！");
        }
    }


}
