package cn.zjm404.demo.di;


import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MyBeansFactory {
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String, MyBeanDefinition> myBeanDefinitions = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<MyBeanDefinition> myBeanDefinitionList) {
        for (MyBeanDefinition myBeanDefinition : myBeanDefinitionList) {
            this.myBeanDefinitions.putIfAbsent(myBeanDefinition.getId(), myBeanDefinition);
        }
        for (MyBeanDefinition myBeanDefinition : myBeanDefinitionList) {
            if (myBeanDefinition.isLazyInit() == false && myBeanDefinition.isSingleton()) {
                createBean(myBeanDefinition);
            }
        }
    }

    @VisibleForTesting
    protected Object createBean(MyBeanDefinition myBeanDefinition) {
        if (myBeanDefinition.isSingleton() && singletonObjects.containsKey(myBeanDefinition.getId())) {
            return singletonObjects.get(myBeanDefinition.getId());
        }
        Object bean = null;
        try {
            Class beanClass = Class.forName(myBeanDefinition.getClassName());
            List<MyBeanDefinition.Property> properties = myBeanDefinition.getProperties();
            if (properties.isEmpty()) {
                bean = beanClass.getDeclaredConstructor().newInstance();
            } else {
                Class[] argClasses = new Class[properties.size()];
                Object[] argObjects = new Object[properties.size()];
                for (int i = 0; i < properties.size(); ++i) {
                    MyBeanDefinition.Property property = properties.get(i);

                    MyBeanDefinition refBeanDefinition = myBeanDefinitions.get(property.getName());
                    if (refBeanDefinition == null) {
                        throw new NoSuchBeanDefinitionException("Bean is not defined" + property.getName());
                    }
                    argClasses[i] = Class.forName(refBeanDefinition.getClassName());
                    argObjects[i] = createBean(refBeanDefinition);
                }
                bean = beanClass.getConstructor(argClasses).newInstance(argObjects);
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if (bean != null && myBeanDefinition.isSingleton()) {
            singletonObjects.putIfAbsent(myBeanDefinition.getId(), bean);
            return singletonObjects.get(myBeanDefinition.getId());
        }
        return bean;
    }

    public Object getBean(String beanId) throws Exception {
        MyBeanDefinition myBeanDefinition = myBeanDefinitions.get(beanId);
        if (myBeanDefinition == null) {
            throw new Exception("未定义：" + beanId);
        }
        return createBean(myBeanDefinition);
    }

}