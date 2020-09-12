package cn.zjm404.stu.dp.organization.proxy;

public class Proxy implements ISubject{
    private ISubject iSubject;
    public Proxy(ISubject _subject){
        this.iSubject = _subject;
    }
    @Override
    public void method() {

        proxyMethod1();
        iSubject.method();
    }
    private void proxyMethod1(){
        //代理角色添加的方法
    }
}
