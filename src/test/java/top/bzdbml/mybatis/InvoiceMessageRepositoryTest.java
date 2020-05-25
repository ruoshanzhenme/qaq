package top.bzdbml.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.bzdbml.entity.InvoiceMessage;
import top.bzdbml.spring.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
@Slf4j

public class InvoiceMessageRepositoryTest {
    @Autowired
    private InvoiceMessageRepository repository;

    @Test
    public void get() {
        InvoiceMessage a = repository.get(2L);
        Assert.assertEquals(a.getId(), Long.valueOf(2L));
    }

    @Test
    public void delete() {
        repository.delete(1L);
        Assert.assertNull(repository.get(1L));
    }

    @Test
    public void insert() {
        Long sb = repository.count();
        InvoiceMessage qqq = new InvoiceMessage();
        qqq.setEnterpriseName("sgsgfff");
        qqq.setDutyParagraph("dhshsdhsdh");
        qqq.setAddress("sgasgag");
        qqq.setPhone(73474347);
        qqq.setBank("dhfdhsdhs");
        qqq.setAccount(7923525);
        qqq.setMessageType(664373);

        Long sbb = repository.count();
        Assert.assertEquals(sb, Long.valueOf(sbb - 1));


    }

    @Test
    public void update() {
        InvoiceMessage qqq = new InvoiceMessage();
        qqq.setEnterpriseName("sgsgfff");
        qqq.setDutyParagraph("dhshsdhsdh");
        qqq.setAddress("sgasgag");
        qqq.setPhone(73474347);
        qqq.setBank("dhfdhsdhs");
        qqq.setAccount(7923525);
        qqq.setMessageType(664373);
        qqq.setEnterpriseId(18L);
        qqq.setId(2L);
        repository.update(qqq);
        InvoiceMessage bbb = repository.get(2L);
        Assert.assertEquals(qqq.getBank(), bbb.getBank());
    }
}