// Question Link : https://leetcode.com/problems/linked-list-cycle-ii/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;  //+1
            fast = fast.next.next;  //+2
            if(slow == fast){
                slow = head;
                while(slow != fast){  //slow = fast again at the node where the cycle began
                    fast = fast.next; //+1
                    slow = slow.next; //+1
                }
                return fast; //fast and slow -> both pointing to the node where the cycle began
            }
        }
        return null;   
    }
}