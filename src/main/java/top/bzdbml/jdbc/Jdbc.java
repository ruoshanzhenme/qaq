package top.bzdbml.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Jdbc {
    //        主函数
    public static void main(String[] args) {
//        建立一个叫做 sql 的字符串 里面是sql的查询语句 当id=?
        String sql = "select * from enterprise where id=?";

//try catch 组合拳
        try (
//                连接数据库
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "zhuxiang");
//                创建一个表达式s 用来传递语句
                Statement s = c.createStatement();
//                创建了一个预编译的表达式 区别在于可以限定参数的类型比如查询条件
                PreparedStatement qwq = c.prepareStatement(sql)
        ) {
//            由用户键入 iddddddd
            Scanner iddddddd = new Scanner(System.in);
            System.out.println("請輸入查询的id");
//            存到qqq中
            String qqq = iddddddd.nextLine();

//建立一个叫做 sql2 的字符串 里面是sql2的查询语句 当id=qqq
            String sql2 = "select* from enterprise where id=" + qqq;
//            使用了表达式s的executeQuery方法执行了携带qqq的查询语句，获取了叫做rs2的结果集（相当于一张表格）
            ResultSet rs2 = s.executeQuery(sql2);
//           当rs2.next为true即当前访问的不是最后一行时 执行
            while (rs2.next()) {
                //获取rs2当前行的id
                long id = rs2.getLong("id");
                String name = rs2.getString("name");
                System.out.println("用普通表达式查出本条记录的id是" + id + " " + "对应的名称是" + name);
            }

            System.out.println(sql);
            //将用户输入的qqq解析成数字，使用setlong方法设置到查询语句指定位置的？里

            qwq.setLong(1, Long.parseLong(qqq));
//            使用了预编译表达式qwq的excuteQuery方法执行了携带限定类型为Long的qqq的查询语句，获取了rs结果集
            ResultSet rs = qwq.executeQuery();
            System.out.println(qwq);
            while (rs.next()) {
                //使用字段名获取对应列的数据并且打印
                long id = rs.getLong("id");
                String englishName = rs.getString("english_name");
                System.out.println("用预编译表达式查出" + id + " " + englishName);

            }
//            String sql="delete from enterprise where id=1 ";
//            s.execute(sql);
            //  捕捉可能的异常并且打印错误信息
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
