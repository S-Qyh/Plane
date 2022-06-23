package cn.QYH.util;

import java.sql.*;

import static cn.QYH.jf.Login.userName;

//用Java实现MySQL的增删改查操作
public class Test1Demo {
    String url = "jdbc:mysql://rm-bp150844nyaa96l67ao.mysql.rds.aliyuncs.com:3306/qyh?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";//mysql8的连接字符串，多了时区比之前的5
    String name = "qyh";
    String password = "QYHqyh10215X";

    public static void main(String[] args) throws SQLException {
        Test1Demo t1 = new Test1Demo();
//        t1.check();
        System.out.println(t1.queryUserInfo().getString(1));
        System.out.println(t1.query("""
                SELECT
                \tuserInfo.*
                FROM
                \tuserInfo
                WHERE
                \tuserInfo.`name` = "user"
                """).getString(1));
        String sql = "insert into mark values(\" "+ userName +"\",\""+ 10 +"\")";
        t1.insert(sql);
    }

    public void check() {
        String sql = "SELECT stu.* FROM stu";
        //1.加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//在有错误提示的时候光标移到错误处，alt+enter，
            try {
                //2.创建连接
                Connection connection = DriverManager.getConnection(url, name, password);
                //3.创建命令窗口
                Statement statement = connection.createStatement();
                //4.执行命令窗口里的语句
                ResultSet resultSet = statement.executeQuery(sql);
                //5.处理返回的结果集
                while (resultSet.next()) {
                    //打印行的每一列
                    System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t\t" + resultSet.getString(3));
//                    System.out.println(resultSet.getString(1));
                }
                //6.关闭资源
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet queryUserInfo() {
        String sql = "SELECT userInfo.* FROM userInfo";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//在有错误提示的时候光标移到错误处，alt+enter，
            try {
                //2.创建连接
                Connection connection = DriverManager.getConnection(url, name, password);
                //3.创建命令窗口
                Statement statement = connection.createStatement();
                //4.执行命令窗口里的语句
                ResultSet resultSet = statement.executeQuery(sql);
                //5.处理返回的结果集
            while (resultSet.next())
                return resultSet;

                //6.关闭资源
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet query(String sql) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//在有错误提示的时候光标移到错误处，alt+enter，
            try {
                //2.创建连接
                Connection connection = DriverManager.getConnection(url, name, password);
                //3.创建命令窗口
                Statement statement = connection.createStatement();
                //4.执行命令窗口里的语句
                ResultSet resultSet = statement.executeQuery(sql);
                //5.处理返回的结果集
                while (resultSet.next())
                    return resultSet;

                //6.关闭资源
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void insert(String sql){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//在有错误提示的时候光标移到错误处，alt+enter，
            try {
                //2.创建连接
                Connection connection = DriverManager.getConnection(url, name, password);
                //3.创建命令窗口
                Statement statement = connection.createStatement();
                statement.execute(sql);
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

