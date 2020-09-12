package cn.zjm404.stu.thread.lock.cas;

public class CASDemo {
    /**
     * 共享资源
     */
    private volatile int count;

    public CASDemo(int _count){
        this.count = _count;
    }

    private synchronized int cas(int expect,int newValue){
        int curValue = count;
        //未有线程修改共享资源，进行更新
        if(curValue == expect){
            count  = newValue;
        }
        //返回修改前的当前值，用于判断是否进行了更新
        return curValue;
    }

    public int increaseAndGet(){
        int newValue;
        //未修改成功则进行自旋
        do{
            newValue = count+1;
        }while(count != cas(count,newValue));
        return count;
    }
}
