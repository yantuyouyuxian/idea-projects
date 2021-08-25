package lesson02;

import lesson02.utils.JdbcUtils;
import lesson04.TestDBCP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    private static ResultSet resultSet = null;

    public static void main(String[] args) throws SQLException {
        resultSet = JdbcUtils.executeQuery("select * from users");
        showResultSet(resultSet);
//        JdbcUtils.executeUpdate("insert into `users` (name,password,`email`,`birthday`)values('赵六','123456','zhaoliu@qq.com','1998-03-21')");
//        resultSet = JdbcUtils.executeQuery("select * from users");
//        showResultSet(resultSet);

//        PreparedStatement ps=JdbcUtils.getPreparedStatement("select * from users where id =?");
//        ps.setString(1,"1");
//        resultSet=ps.executeQuery();
//        showResultSet(resultSet);

        System.out.println(JdbcUtils.getConnection().getAutoCommit());

        JdbcUtils.close();
    }

    public static void showResultSet(ResultSet resultSet) {
        try {
            TestDBCP.showResultSet(resultSet);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
