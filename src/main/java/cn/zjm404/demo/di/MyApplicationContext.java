package cn.zjm404.demo.di;

public interface MyApplicationContext {
    Object getBean(String beanId) throws Exception;
}
