/**
 * @Author
 * @Date 2020/11/16
 * @Description
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        ListNode list = new Solution().addTwoNumbers(l1,l2);
        while(list != null){
            System.out.println(list.val);
            list = list.next;
        }
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = l1;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int sum = 0;
        ListNode lp = l1;
        while(l1 != null && l2 != null){
            int num = l1.val + l2.val + sum;
            sum = num > 9 ? num % 9 : 0;
            l1.val = sum == 0 ? num : num - 10;
            lp = l1;
            l1 = l1.next;
            l2 = l2.next;
            sum = sum > 0 ? 1 : 0;
        }
        if(sum != 0){
            if(l1 == null && l2 == null){
                lp.next = new ListNode(sum);
                return res;
            }
            if(l1 == null){
                lp.next = l2;
                l1 = lp.next;

            }
            while(sum != 0){
                int num = l1.val + sum;
                sum = num > 9 ? num % 9 : 0;
                l1.val = sum == 0 ? num : num - 10;
                lp = l1;
                l1 = l1.next;
                sum = sum > 0 ? 1 : 0;
                if(l1 == null && sum > 0){
                    lp.next = new ListNode(sum);
                    break;
                }
            }
        }else{
            if(l2 != null){
                lp.next = l2;
                return res;
            }
        }
        return res;
    }
}