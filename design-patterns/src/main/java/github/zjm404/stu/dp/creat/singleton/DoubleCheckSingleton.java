package github.zjm404.stu.dp.creat.singleton;

public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton instance = null;
    public static DoubleCheckSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
