// Question Link : https://leetcode.com/problems/linked-list-cycle/

public class Solution {
    public boolean hasCycle(ListNode head) { //Floyd's Cycle Finding Algorithm
        ListNode slow = head;
        ListNode  fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){ 
                return true;
            }
        }
        return false; 
    }
}