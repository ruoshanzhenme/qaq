package top.bzdbml.jdbc;

import top.bzdbml.entity.Enterprise;

import java.sql.*;

public class Dao {

    /**
     * 从数据库中根据id取出对应的Enterprise对象
     *
     * @param id id
     * @return 企业对象
     */
    public static Enterprise getById(Long id) {
        String sql = "select*from enterprise where id=?";
        try (
//                一个登陆数据库的动作，后面的参数就是你的帐号和密码
//                返回的c就是一个数据库连接对象，通过它你就可以对这个数据库做添删改查动作了
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "zhuxiang");
//                 实例化预编译表达式 ps ，通过引用c对象并且需要输入sql
                PreparedStatement ps = c.prepareStatement(sql)

        ) {
//
            ps.setLong(1, id);
//            通过executeQuery方法更新查询来获取结果集rs
            ResultSet rs = ps.executeQuery();

            rs.next();
            Enterprise a = new Enterprise();
            a.setId(rs.getLong("id"));
            a.setLogo(rs.getString("logo"));
            a.setAbbreviation(rs.getString("abbreviation"));
            a.setEmail(rs.getString("email"));
            a.setEnglishName(rs.getString("english_name"));
            a.setName(rs.getString("name"));
            a.setPersonInCharge(rs.getString("person_in_charge"));
            a.setPhone(rs.getInt("phone"));
            return a;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id从数据库中删除对应的行
     *
     * @param id
     */

    public static void delete(Long id) {
        String sql = "delete from enterprise where id=?";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "zhuxiang");
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * 将enterprise对象在数据库中进行插入
     *
     * @param enterprise
     */
    public static void insert(Enterprise enterprise) {
        String sql = "INSERT INTO test.enterprise (english_name, abbreviation, person_in_charge, phone, email, logo, name) VALUES (?,?,?,?,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "zhuxiang");
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, enterprise.getEnglishName());
            ps.setString(2, enterprise.getAbbreviation());
            ps.setString(3, enterprise.getPersonInCharge());
            ps.setLong(4, enterprise.getPhone());
            ps.setString(5, enterprise.getEmail());
            ps.setString(6, enterprise.getLogo());
            ps.setString(7, enterprise.getName());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * 将Enterprise类型的a 在数据库中进行更新
     *
     * @param a
     */
    public static void update(Enterprise a) {
        String sql = "update enterprise set  english_name=?, abbreviation=?, person_in_charge=?, phone=?, email=?, logo=?, name=?  where id=?";
        try (Connection b = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "zhuxiang");
             PreparedStatement c = b.prepareStatement(sql)

        ) {
            c.setString(1, a.getEnglishName());
            c.setString(2, a.getAbbreviation());
            c.setString(3, a.getPersonInCharge());
            c.setLong(4, a.getPhone());
            c.setString(5, a.getEmail());
            c.setString(6, a.getLogo());
            c.setString(7, a.getName());
            c.setLong(8, a.getId());
            c.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        Enterprise qq = new Enterprise();
        qq.setPhone(123);
        qq.setPersonInCharge("啊");
        qq.setName("dgh");
        qq.setEnglishName("dfhjsd");
        qq.setEmail("468936@sfafaf");
        qq.setAbbreviation("fghsjahraerejh");
        qq.setLogo("wwww.wwwwwwwww");
        qq.setId(3L);
        update(qq);


    }
}
