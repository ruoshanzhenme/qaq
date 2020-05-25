package top.bzdbml.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.bzdbml.entity.Enterprise;
import top.bzdbml.mybatis.EnterpriseRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
@Slf4j
public class EnterpriseRepositoryTest {
    @Autowired
    EnterpriseRepository repository;

//    static Logger logger = LoggerFactory.getLogger(EnterpriseRepositoryTest.class);

    @Test
    public void get() {
        Enterprise b = repository.get(18L);
        log.info("获取Enterprise类对象成功，ID是{}，名称是{}", b.getId(), b.getName());
        Assert.assertEquals(b.getId(), Long.valueOf(18L));
    }
}


