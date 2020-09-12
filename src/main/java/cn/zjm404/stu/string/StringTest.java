package cn.zjm404.stu.string;

public class StringTest {
    public static void main(String[] args) {
        String s = "HW 𪚥𪚥";
        int len = s.length();
        for (int i = 0; i < len;) {
            int codepoint = s.codePointAt(i);
            char[] c = Character.toChars(codepoint);
            System.out.println(c);
            i += Character.charCount(codepoint);

        }
    }
}
