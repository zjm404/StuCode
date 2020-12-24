package github.zjm404.stu.java.object;

/**
 * @author
 * @date 2020/12/2
 */
public class ObjectTest {
    public static void main(String[] args) {
//        Sub sub = new Sub();
//        sub.setMsg3(false);
//        sub.setMsg1("hello world");
//        sub.setMsg2(1);
//        sub.setMsg4("HELLO WORLD");

//        Parent p1 = sub;
//        Sub sub1 = (Sub) p1;
//        System.out.println(sub1.getMsg4());
//        System.out.println(0>>1);
//        int[] i = new int[]{1,2};
        new Solution().searchRange(new int[]{1},1);
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len == 0 ){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = len-1;
        int mid = 0;
        while(left <= right){
            mid = (left+right)>>1;
            if(nums[mid] == target){
                break;
            }else if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }
        }
        if(nums[mid] != target){
            return new int[]{-1,-1};
        }
        left = mid;
        while(left > 0){
            left--;
            if(nums[left] != target){
                left++;
                break;
            }
        }
        right = mid;
        while(right < len-1){
            right++;
            if(nums[right] != target){
                right--;
                break;
            }
        }
        int[] res = new int[2];
        res[0] = left;
        res[1] = right;
        return res;
    }
}
