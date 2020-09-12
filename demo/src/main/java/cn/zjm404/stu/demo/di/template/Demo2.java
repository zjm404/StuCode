package cn.zjm404.stu.demo.di.template;

import cn.zjm404.stu.demo.di.bean.MusicProviderFacade;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Demo2 {
    public static void main(String[] args) {
        //资源定位
        Resource resource = new ClassPathResource("spring/demo.xml");
        //读取配置文件将配置文件转为BeanDefinition
        BeanFactory bf = new DefaultListableBeanFactory();
        BeanDefinitionReader bdr = new XmlBeanDefinitionReader((BeanDefinitionRegistry) bf);
        //载入BeanDefinition到 IoC
        bdr.loadBeanDefinitions(resource);
        MusicProviderFacade musicProviderFacade1 = (MusicProviderFacade) bf.getBean("MusicProviderFacade");
        musicProviderFacade1.search("hello world");
    }
}
