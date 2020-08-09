package cn.zjm404.demo.di;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyClassPathXmlApplicationContext implements MyApplicationContext {
    private MyBeansFactory myBeansFactory;
    private MyBeanConfigParser myBeanConfigParser;

    public MyClassPathXmlApplicationContext(String configLocation) {
        this.myBeansFactory = new MyBeansFactory();
        this.myBeanConfigParser = new MyXMLBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
        try(InputStream in = this.getClass().getResourceAsStream(configLocation)) {

            List<MyBeanDefinition> myBeanDefinitions = myBeanConfigParser.parse(in);
            myBeansFactory.addBeanDefinitions(myBeanDefinitions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanId) throws Exception {
        return myBeansFactory.getBean(beanId);
    }

}
