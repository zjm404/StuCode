package cn.zjm404.stu.string;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
    }

}
class LengthTest{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int len = sb.length();
        System.out.println(len);
    }
}
