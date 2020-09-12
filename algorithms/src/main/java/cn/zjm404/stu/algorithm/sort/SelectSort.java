package cn.zjm404.stu.algorithm.sort;

public class SelectSort {
    public static void sort(int[] a){
        for(int i = 0 ; i < a.length-1 ; i++){
            int min = i;
            for(int j = i+1 ; j < a.length;j++){
                min = a[min] > a[j] ? j : min;
            }
            swap(a,i,min);
        }
    }
    private static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
class SelectSortTest{
    public static void main(String[] args){
        int[] a = new int[]{1,4,2,6,1,9};
        SelectSort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
