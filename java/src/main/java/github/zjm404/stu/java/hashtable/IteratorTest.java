package github.zjm404.stu.java.hashtable;

import java.util.Hashtable;

public class IteratorTest {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("k1","hello");
        hashtable.put("k2","world");
        hashtable.put("k3","HELLO");
        hashtable.put("k4","WORLD");
        for (String s : hashtable.keySet()) {
            if (hashtable.containsKey("k3")){
                hashtable.remove("k3");
            }
            System.out.println(s);
        }
    }
}
