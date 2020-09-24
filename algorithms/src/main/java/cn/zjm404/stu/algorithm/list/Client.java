package cn.zjm404.stu.algorithm.list;

import java.util.Iterator;
import java.util.LinkedList;

public class Client {
    public static void main(String[] args) {
        NoSentryLinkedList<String> nl = new NoSentryLinkedList<>();
        System.out.println("-------插入节点 测试---------------------");
        nl.add("hello");
        nl.add("world");
        nl.addFirst("WORLD");
        nl.addFirst("HELLO");

        for (String s : nl) {
            System.out.println(s);
        }
        System.out.println("-------删除 首节点 测试---------------------");
        nl.removeFirst();
        for (String s : nl) {
            System.out.println(s);
        }

        System.out.println("-------遍历删除 WORLD 测试---------------------");
        Iterator<String> iterator = nl.iterator();
        while(iterator.hasNext()){
            String cur = iterator.next();
            if(cur.equals("WORLD")){
                iterator.remove();
                continue;
            }
            System.out.println(cur);
        }
        System.out.println("-------当前状态---------------------");
        for (String s : nl) {
            System.out.println(s);
        }

        System.out.println("-------删除 world 测试---------------------");
        nl.remove("world");
        for (String s : nl) {
            System.out.println(s);
        }
        System.out.println("-------删除 最后一个节点 hello 测试---------------------");
        System.out.println("删除 hello 是否成功:"+nl.remove("hello"));
        System.out.println("查找 hello 是否存在:"+nl.contain("hello"));

    }
}
class Client2{
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("hello");
        list.add("world");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String res = iterator.next();
            if (res.equals("hello")){
                iterator.remove();
                continue;
            }
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
