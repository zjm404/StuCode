package cn.zjm404.demo.di.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseSpringDI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/demo.xml");
        MyTestBean bean = (MyTestBean) context.getBean("myTestBean");
        System.out.println(bean.getMsg());
    }
}
