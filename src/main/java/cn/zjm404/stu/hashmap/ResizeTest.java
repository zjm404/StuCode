package cn.zjm404.stu.hashmap;

import java.util.HashMap;

/**
 * @author ZJM
 */
public class ResizeTest {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap(2);
        hashMap.put("hello",1);
        hashMap.put("world",1);
        hashMap.put("test",1);
    }
}
