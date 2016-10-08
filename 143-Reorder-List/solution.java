/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {  
        
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

        }
        // now slow is the mid, reverse from slow->next to end

        ListNode prev = null;
        ListNode curt = slow.next;
        // break the connection
        slow.next = null;
        
        while (curt != null) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        // Ln starts from prev, L0 starts from head
        curt = new ListNode(-1);
        ListNode temp = head;
        
        while(prev != null) {
            curt.next = temp;
            temp = temp.next;
            curt = curt.next;
            curt.next = prev;
            prev = prev.next;
            curt = curt.next;
        }
        
        if (temp != null) {
            curt.next = temp;
        }

    }
}