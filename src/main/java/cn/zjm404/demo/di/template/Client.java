package cn.zjm404.demo.di.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/demo.xml");
        MusicProviderFacade musicProviderFacade = (MusicProviderFacade) applicationContext.getBean("MusicProviderFacade");
        musicProviderFacade.search("hello world");
    }
}
