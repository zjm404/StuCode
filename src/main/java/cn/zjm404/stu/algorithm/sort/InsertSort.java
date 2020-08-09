package cn.zjm404.stu.algorithm.sort;

/**
 * @author ZJM
 */
public class InsertSort {
    public void insertSort(int[] a){
        for(int i = 1; i < a.length; i++){
            int tmp = a[i];
            int j = i-1;
            while(tmp < a[j] && j >= 0){
                a[j+1] = a[j];
                j--;
            }
            if(a[j] < tmp){
                a[j+1] = tmp;
            }else{
                a[j] = tmp;
            }
        }
    }
}
class InsertSortTest{
    public static void main(String[] args) {
        int[] a = {1,2,4,2,1,5,2,7,1};
        new InsertSort().insertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
