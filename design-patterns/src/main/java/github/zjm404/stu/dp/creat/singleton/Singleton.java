package github.zjm404.stu.dp.creat.singleton;

public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
