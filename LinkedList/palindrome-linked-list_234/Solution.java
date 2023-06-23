// Question Link : https://leetcode.com/problems/palindrome-linked-list/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){ //for LL containing one node
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){  //finding mid node
            slow = slow.next;  
            fast = fast.next.next;  
        }

        ListNode curr = slow; //mid node
        ListNode prev = null;
        ListNode next;
        while(curr!=null){  //reversing right half of LL
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode left = head;  //head of left half
        ListNode right = prev;  //head of right half
        while(right != null) {  
            if(left.val != right.val){ //comparing data of left and right half of LL
                return false;
            }
            left = left.next;
            right = right.next;
        } 
        return true;   
    }
}