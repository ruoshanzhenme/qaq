package top.bzdbml.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.bzdbml.entity.Enterprise;

import java.io.IOException;
import java.io.InputStream;

public class laji {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSession session = new SqlSessionFactoryBuilder().build(inputStream).openSession();

        EnterpriseRepository mapper = session.getMapper(EnterpriseRepository.class);

        System.out.println(mapper.get(3L));
//        mapper.delete(9L);
        Enterprise qq = new Enterprise();
        qq.setPhone(123);
        qq.setPersonInCharge("啊");
        qq.setName("dgh");
        qq.setEnglishName("dfhjsd");
        qq.setEmail("468936@sfafaf");
        qq.setAbbreviation("fghsjahraerejh");
        qq.setLogo("wwww.wwwwwwwww");
        qq.setId(34L);
        mapper.update(qq);

        session.commit();
        session.close();
    }
}
