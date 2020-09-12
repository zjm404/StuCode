package cn.zjm404.stu.demo.di.template;

import cn.zjm404.stu.demo.di.bean.*;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.*;

public class Demo {
    public static void main(String[] args) {
        // 1.创建管理 BeanDefinition 的容器
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
        // 2.生成 BeanDefinition
        AbstractBeanDefinition kgMusicProvider = new RootBeanDefinition(KGMusicProvider.class);
        AbstractBeanDefinition ttpodMusicProvider = new RootBeanDefinition(TTPODMusicProvider.class);
        AbstractBeanDefinition wyyMusicProvider = new RootBeanDefinition(WYYMusicProvider.class);
        AbstractBeanDefinition musicProviderFacade = new RootBeanDefinition(MusicProviderFacade.class);
        //  3.注册 BeanDefinition 到容器中
        registry.registerBeanDefinition("kgMusicProvider",kgMusicProvider);
        registry.registerBeanDefinition("ttpodMusicProvider",ttpodMusicProvider);
        registry.registerBeanDefinition("wyyMusicProvider",wyyMusicProvider);
        registry.registerBeanDefinition("musicProviderFacade",musicProviderFacade);
        //  4.装配属性，通过 setter 方式装配
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        //  4.1 添加 list
        ManagedList managedList = new ManagedList();
        managedList.add(kgMusicProvider);
        managedList.add(ttpodMusicProvider);
        managedList.add(wyyMusicProvider);
        propertyValues.addPropertyValue("musicProvidersList",managedList);
        //  4.2 装配属性
        musicProviderFacade.setPropertyValues(propertyValues);

        //5.获取依赖
        MusicProviderFacade mpf = (MusicProviderFacade) beanFactory.getBean("musicProviderFacade");
        mpf.search("test");

    }
}
