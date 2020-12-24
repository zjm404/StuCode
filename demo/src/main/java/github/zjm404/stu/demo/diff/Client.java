package github.zjm404.stu.demo.diff;

import java.util.*;

public class Client {
    //删除第一个元素
    public static void remove1(List list1){


        Iterator iterator = list1.iterator();
        while(iterator.hasNext()){
            iterator.next();
            //如果要删除当前元素，removePre = true;
            iterator.remove();
        }
    }

    //删除最后一个元素
    public static void remove2(List list1){
        boolean removePre = false;
        //记录当前下标
        int flag = 0;
        //记录最后一个元素下标
        int lastFlag = list1.size()-1;
        for (Object s : list1) {
            if(removePre){
                list1.iterator().remove();
                removePre = false;
            }
            //如果要删除当前元素，removePre = true;
            if(flag == lastFlag){
                removePre = true;
            }
            flag++;
        }
        if(removePre){
            //删除最后一个元素,如果是LinkedList，使用removeLast()
            list1.remove(list1.size()-1);
            removePre = false;
        }
    }

    public static void main(String[] args) {
//        List<String> list1 = Arrays.asList("h1","h2","h3");
//        List<String> list2 = Arrays.asList("h1","h2","h4");
//        List<String> res = new GetDiffNodeDemo<String>().getDiffNodes(list1,list2);
//        for (String re : res) {
//            System.out.println(res);
//        }
//        ArrayList<String> list1 = (ArrayList<String>) Arrays.asList("h1","h2","h3");
//        boolean removePre = false;
//        for (String s : list1) {
//            if(removePre){
//                list1.iterator().remove();
//                removePre = false;
//            }
//            //如果要删除当前元素，removePre = true;
//        }
//        if(removePre){
//            //删除最后一个元素,如果是LinkedList，使用removeLast()
//            list1.remove(list1.size()-1);
//            removePre = false;
//        }
        List<String> list1 = new ArrayList();
        list1.add("hello1");
        list1.add("hello2");
        list1.add("hello3");
        remove1(list1);
        list1.stream().forEach(System.out::println);
    }
}
