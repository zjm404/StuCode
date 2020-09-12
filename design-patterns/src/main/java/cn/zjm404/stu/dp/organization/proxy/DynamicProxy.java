package cn.zjm404.stu.dp.organization.proxy;

import javax.security.auth.Subject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    Class cls;
    Object obj;
    public DynamicProxy(Object _obj){
        this.obj = _obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.obj, args);
        return result;
    }
}
class Client1{
    public static void main(String[] args) {
        Subject subject = new Subject();
        InvocationHandler handler = new DynamicProxy(subject);
        ClassLoader cl = subject.getClass().getClassLoader();
//        DynamicProxy proxy = Proxy.newProxyInstance(cl,new Class)
    }
}
