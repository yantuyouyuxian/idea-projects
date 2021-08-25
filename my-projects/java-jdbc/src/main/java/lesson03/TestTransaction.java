package lesson03;

import lesson02.utils.JdbcUtils;

import java.sql.SQLException;

public class TestTransaction {
    public static void main(String[] args) throws SQLException {
        try {
            System.out.println(JdbcUtils.getConnection().getAutoCommit());

            JdbcUtils.getConnection().setAutoCommit(false);

            System.out.println(JdbcUtils.getConnection().getAutoCommit());
            int a=0,b=0;
            a=JdbcUtils.executeUpdate("update account set money=money-100 where name='A'");
            b=JdbcUtils.executeUpdate("update account set money=money+100 where name='Basdfasdf'");
            if(a>0 && b>0){
                JdbcUtils.getConnection().commit();
            }else{
                JdbcUtils.getConnection().rollback();
            }
        } catch (SQLException e) {
            JdbcUtils.getConnection().rollback();
            e.printStackTrace();
        }finally {
            JdbcUtils.close();
        }
    }
}
