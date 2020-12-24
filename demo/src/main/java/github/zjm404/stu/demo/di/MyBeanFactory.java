package github.zjm404.stu.demo.di;

import java.util.concurrent.ConcurrentHashMap;

public class MyBeanFactory {
    private ConcurrentHashMap<String,Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,MyBeanDefinition> myBeanDefinitions = new ConcurrentHashMap<>();

    public void registerBeanDefinition(MyBeanDefinition myBeanDefinition){
        myBeanDefinitions.putIfAbsent(myBeanDefinition.getId(),myBeanDefinition);
        if(myBeanDefinition.isLazyInit() && myBeanDefinition.isSingleton()){
            createBean(myBeanDefinition);
        }
    }
    private Object createBean(MyBeanDefinition myBeanDefinition){
        if(myBeanDefinition.isSingleton() && singletonObjects.containsKey(myBeanDefinition.getId())){
            return singletonObjects.get(myBeanDefinition.getId());
        }
        Object bean = null;
        try{
            Class cl = Class.forName(myBeanDefinition.getClassName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
