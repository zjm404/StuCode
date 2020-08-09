package cn.zjm404.stu.multithreading.lock.internal;

public class SynchronizedTest {
    private static SynchronizedTest instance;

    private int num;

    //修饰静态方法，锁类对象
    public static synchronized SynchronizedTest getInstance1(){
        if(null == instance){
            instance = new SynchronizedTest();
        }
        return instance;
    }
    //修饰代码块，锁指定对象
    public static SynchronizedTest getInstance2(){
        if(null == instance){
            synchronized (SynchronizedTest.class){
                if(null == instance){
                    instance = new SynchronizedTest();
                }
            }
        }
        return instance;
    }
    //修饰非静态方法，锁当前对象（这个代码纯粹是为了演示）
    public synchronized void add(int num){
        num++;
    }
}
