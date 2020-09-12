package cn.zjm404.stu.dp.organization.proxy;

public class Subject implements ISubject{
    private Proxy proxy;
    @Override
    public void method() {
        if(!isProxy()){
            //抛出一个异常~
        }
        //写要完成的任务
    }
    public ISubject getProxy(){
        this.proxy = new Proxy(this);
        return this.proxy;
    }
    public boolean isProxy(){
        return this.proxy != null;
    }
}
