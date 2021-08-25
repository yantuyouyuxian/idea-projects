package lesson04;

import lesson04.utils.JdbcUtils_C3P0;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestC3P0 {
    public static void main(String[] args) throws SQLException {

        ResultSet resultSet= JdbcUtils_C3P0.executeQuery("select * from users");

        showResultSet(resultSet);

        JdbcUtils_C3P0.close();

    }

    public static void showResultSet(ResultSet resultSet) throws SQLException {
        printRS(resultSet);
    }

    static void printRS(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            System.out.println("id:" + resultSet.getObject("id"));
            System.out.println("name:" + resultSet.getObject("name"));
            System.out.println("password:" + resultSet.getObject("password"));
            System.out.println("email:" + resultSet.getObject("email"));
            System.out.println("birthday:" + resultSet.getDate("birthday"));
        }
    }
}
