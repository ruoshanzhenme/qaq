package top.bzdbml.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.bzdbml.mybatis.EnterpriseRepository;


public class App {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);


        EnterpriseRepository t2 = context.getBean(EnterpriseRepository.class);
        System.out.println(t2.get(4L));
    }

}