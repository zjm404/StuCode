package cn.zjm404.stu.java.hashtable;

import java.util.Enumeration;
import java.util.Hashtable;

public class EnumeratorTest {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("k1","hello");
        hashtable.put("k2","world");
        hashtable.put("k3","HELLO");
        hashtable.put("k4","WORLD");
        Enumeration enumeration = hashtable.elements();
        hashtable.remove("k3");
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
}
