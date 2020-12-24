package github.zjm404.stu.dp.organization.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    Object obj;
    public DynamicProxy(Object _obj){
        this.obj = _obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.obj, args);
        return result;
    }
    private void before(){
        System.out.println("hello world~");
    }
}
class Client1{
    public static void main(String[] args) {
        ISubject subject1 = new Proxy(new github.zjm404.stu.dp.organization.proxy.Subject());
        subject1.method();
    }
}
