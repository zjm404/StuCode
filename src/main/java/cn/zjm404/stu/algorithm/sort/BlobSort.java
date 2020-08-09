package cn.zjm404.stu.algorithm.sort;

public class BlobSort{
    public static void sort(int[] a){
        boolean isSorted = false;
        for(int i = 1 ; i < a.length; i++){
            for(int j = 0; j < a.length-i; j++){
                if(a[j] > a[j+1]){
                    isSorted = true;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            if(!isSorted){
                break;
            }
        }
    }
}
class BlobSortTest{
    public static void main(String[] args) {
        int[]a = new int[]{12,4,1,6,2};
        BlobSort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}

