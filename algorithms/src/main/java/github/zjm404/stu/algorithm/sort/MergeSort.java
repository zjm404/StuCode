package github.zjm404.stu.algorithm.sort;

import java.util.Arrays;

/**
 * @author ZJM
 */
public class MergeSort {
    public static int[] mergeSort(int[] nums){
        int len = nums.length;
        if(len <= 1){
            return nums;
        }
        int mid = (len)>>1;
        int[] left = Arrays.copyOfRange(nums,0,mid);
        int[] right = Arrays.copyOfRange(nums,mid,len);
        return merge(mergeSort(left),mergeSort(right));

    }
    private static int[] merge(int[] nums1,int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] tmp = new int[len1+len2];
        int i = 0,j = 0,k = 0;
        while(i < len1 && j < len2){
            tmp[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while(i < len1){
            tmp[k++] = nums1[i++];
        }
        while(j < len2){
            tmp[k++] = nums2[j++];
        }
        return tmp;
    }
}
class MergeSortTest{
    public static void main(String[] args) {
        int[] nums = {1};
        nums = MergeSort.mergeSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
