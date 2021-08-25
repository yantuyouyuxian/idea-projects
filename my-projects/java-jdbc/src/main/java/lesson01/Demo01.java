package lesson01;

import lesson02.Test;

import java.sql.*;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动
        //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2、用户信息url
        String URL="jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
        String USER="root";
        String PASSWORD="2242757980";
        //3、连接，connection代表数据库
        Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
        //4、创建执行对象
        Statement statement=connection.createStatement();
        //5、执行语句返回结果
        String sql="select * from users";
        ResultSet resultSet=statement.executeQuery(sql);
        Test.showResultSet(resultSet);
        //6、释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
