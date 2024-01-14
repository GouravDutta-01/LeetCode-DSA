// Question Link : https://leetcode.com/problems/add-two-numbers/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1); //dummy node
        ListNode curr = temp;
        int carry = 0;
        while(l1 != null || l2 != null){ //till both l1 and l2 becomes null
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(sum%10); //storing the sum in newNode
            carry = sum/10;
            curr.next = newNode;
            curr = curr.next;    
        }
        if(carry != 0){ //remaining carry
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        return temp.next;    
    }
}