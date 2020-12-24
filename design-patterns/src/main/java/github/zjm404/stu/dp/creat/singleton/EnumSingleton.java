package github.zjm404.stu.dp.creat.singleton;

public enum EnumSingleton {
    INSTANCE;
    private EnumSingleton(){
    }
}
class EnumSingletonRun{
    public static void main(String[] args) {
        EnumSingleton e = EnumSingleton.INSTANCE;
    }
}
