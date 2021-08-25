package lesson04.utils;


import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils_DBCP {

    private static Statement state = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static DataSource dataSource=null;

    static {
        try {
            InputStream inputStream = JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            dataSource=BasicDataSourceFactory.createDataSource(properties);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnection() throws SQLException {

        return dataSource.getConnection();
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
            System.out.println("成功关闭！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("成功失败！");
        }
    }


}
