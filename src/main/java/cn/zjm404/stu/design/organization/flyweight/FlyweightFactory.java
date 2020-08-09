package cn.zjm404.stu.design.organization.flyweight;

import java.util.ArrayList;

public class FlyweightFactory {
    /**
     * 缓存
     */
    private static final ArrayList<SharedObject> cache = new ArrayList<>();

    /**
     *
     * @param param1 共享的
     * @param param2 共享的
     * @param param3 非共享的
     * @param param4 非共享的
     * @return
     */
    public static Flyweight getFlyweight(String param1,String param2,String param3,int param4){
        SharedObject sharedObject = new SharedObject(param1,param2);
        for (SharedObject object : cache) {
            if(sharedObject.equals(object) == true){
                sharedObject = object;
            }else {
                cache.add(sharedObject);
            }
        }
        return new Flyweight(param3,param4,sharedObject);
    }
}
