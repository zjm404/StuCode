package github.zjm404.stu.algorithm.sort;

import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] nums){
        sort(nums,0,nums.length-1);
    }
    private static void sort(int[] a,int left,int right){
        if(left >= right){
            return;
        }
        //获取pivot
        int pivot = getPivotMethod2(a,left,right);
        //进行分区排序
        pivot = partition1(a,left,right,pivot);
//        pivot = partition2(a,left,right,pivot);
        sort(a,left,pivot-1);
        sort(a,pivot+1,right);
    }

    /**
     * 单边
     * @param a
     * @param left
     * @param right
     * @param pivot
     * @return
     */
    private static int partition1(int[] a,int left,int right,int pivot){
        //小于pivot的元素的边界
        int mark = left;
        int pivotV = a[pivot];
        for(int i = left+1 ; i <= right; i++){
            if(a[i] < pivotV){
                mark++;
                swap(a,mark,i);
            }
        }
        swap(a,mark,pivot);
        return mark;
    }
    private static int partition2(int[] a,int left,int right,int pivot){
        while(left != right){
            while(a[left] <= a[pivot] && left < right){
                left++;
            }
            while(a[right] > a[pivot] && left < right){
                right--;
            }
            if(left < right){
                swap(a,left,right);
            }
        }
        swap(a,left,pivot);
        return left;
    }
    /**
     * pivot为第一个元素
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int getPivotMethod1(int[] nums,int left,int right){
        return left;
    }

    /**
     * pivot为随机数
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int getPivotMethod2(int[] nums,int left,int right){
        Random random = new Random();
        int pivot = random.nextInt(right-left+1)+left;
        swap(nums,left,pivot);
        return left;
    }
    private static void swap(int[] nums,int f1,int f2){
        int tmp = nums[f1];
        nums[f1] = nums[f2];
        nums[f2] = tmp;
    }

}
class QuickSortTest{
    public static void main(String[] args) {
        int[] nums = {1,6,2,9,0,6,6,7,4};
        QuickSort.quickSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
