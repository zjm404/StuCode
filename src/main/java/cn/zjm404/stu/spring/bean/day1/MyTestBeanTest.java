package cn.zjm404.stu.spring.bean.day1;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MyTestBeanTest {
    public static void main(String[] args) {
        Resource resource;
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("MyTestBean.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        System.out.println(bean.getMsg());
    }
}
