package cn.zjm404.stu.algorithm.sort;

public class CountingSort {
    public static void sort(int[] a){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int len = 0;
        for (int i : a) {
            min = min < i ? min : i;
            max = max > i ? max : i;
            len++;
        }
        int s = min - 0;
        int[] nums;
    }
}
class CountingSortTest{
    public static void main(String[] args) {
        String[] ss = new String[2];
        String s = ss[0]+ss[1];
//        s.substring();
    }
}