package top.bzdbml.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelloWorld {
    //    构建一个不需要返回值的delete方法   需要提供数据类型为long的变量id （long的大小写）
    public static void delete(long id) {

        String sql = "delete from  enterprise where id=?";
        try (Connection a = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "zhuxiang");
             PreparedStatement b = a.prepareStatement(sql)

        ) {


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
