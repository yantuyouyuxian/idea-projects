package lesson04;

import lesson04.utils.JdbcUtils_DBCP;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDBCP {
    public static void main(String[] args) throws SQLException {
        ResultSet resultSet=JdbcUtils_DBCP.executeQuery("select * from users");

        showResultSet(resultSet);

        JdbcUtils_DBCP.close();
    }

    public static void showResultSet(ResultSet resultSet) throws SQLException {
        TestC3P0.printRS(resultSet);
    }
}
