package github.zjm404.stu.demo.di;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义 bean 的属性
 */
@Getter
@Setter
public class MyBeanDefinition {
    /**
     * bean 的 ID,通过 ID 获取 bean
     */
    private String id;
    /**
     * class
     */
    private String className;
    /**
     * bean 的作用域，默认为单例模式
     */
    private MyScope scope = MyScope.SINGLETON;
    /**
     * 是否延迟加载，默认为 false
     */
    private boolean lazyInit = false;

    private List<ConstructorArg> constructorArgs = new ArrayList<>();



    /**
     * bean 的作用域
     */
    public static enum MyScope{
        /**
         * 单例模式，在容器的生命周期内，一个类只有一个实例
         */
        SINGLETON,
        /**
         * 每次请求，都获取一个实例
         */
        PROTOTYPE
    }
    @Getter
    @Setter
    public static class ConstructorArg{
        private boolean isRef;
        private Class type;
        private Object arg;
    }

    public MyBeanDefinition(String _id,String _className,MyScope _scope,boolean _lazyInit,ArrayList<ConstructorArg> _constructorArgs){
        this.id = _id;
        this.className = _className;
        this.scope = _scope;
        this.lazyInit = _lazyInit;
        this.constructorArgs = _constructorArgs;
    }
    public MyBeanDefinition(String _className){
        this(_className,_className,MyScope.SINGLETON,false,null);
    }
    public boolean isLazyInit(){
        return this.lazyInit;
    }
    public boolean isSingleton(){
        return this.scope == MyScope.SINGLETON;
    }
}
