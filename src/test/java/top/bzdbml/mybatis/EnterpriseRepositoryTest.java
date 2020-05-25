package top.bzdbml.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import top.bzdbml.entity.Enterprise;

import java.io.IOException;
import java.io.InputStream;

public class EnterpriseRepositoryTest {
    EnterpriseRepository a;

    @Before
    public void setup() {
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSession session = new SqlSessionFactoryBuilder().build(inputStream).openSession();

        a = session.getMapper(EnterpriseRepository.class);
    }

    @Test
    public void get() {
        Enterprise b = a.get(18L);
        Assert.assertEquals(b.getId(), Long.valueOf(18L));
    }

    @Test
    public void delete() {
        a.delete(9L);
        Assert.assertNull(a.get(9L));
    }

    @Test
    public void insert() {
        Long nt = a.count();
        Enterprise qq = new Enterprise();
        qq.setPhone(123);
        qq.setPersonInCharge("啊");
        qq.setName("dgh");
        qq.setEnglishName("dfhjsd");
        qq.setEmail("468936@sfafaf");
        qq.setAbbreviation("fghsjahraerejh");
        qq.setLogo("wwww.wwwwwwwww");
        a.insert(qq);
        Long sb = a.count();
        Assert.assertEquals(nt, Long.valueOf(sb - 1L));
    }

    @Test
    public void update() {
        Enterprise qq = new Enterprise();
        qq.setPhone(123);
        qq.setPersonInCharge("啊");
        qq.setName("dgh");
        qq.setEnglishName("dfhjsd");
        qq.setEmail("468936@sfafaf");
        qq.setAbbreviation("fghsjahraerejh");
        qq.setLogo("wwww.wwwwwwwww");
        qq.setId(15L);
        a.update(qq);

        Enterprise b = a.get(15L);
        Assert.assertEquals(qq.getPhone(), b.getPhone());
    }
}