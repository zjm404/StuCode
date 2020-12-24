package github.zjm404.stu.java.exception;

import java.util.Objects;

/**
 * @author
 * @date 2020/12/18
 */
public class Client {
    public static void main(String[] args) {
//        new Demo().run();
        String s = "111234";
        Integer i = 111234;
        System.out.println(Objects.equals(String.valueOf(i),s));
    }
}
