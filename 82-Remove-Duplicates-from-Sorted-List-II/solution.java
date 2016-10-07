/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int temp = Integer.MIN_VALUE;
        ListNode prev = dummy;

        if (head == null) {
            return null;
        }

        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                head = head.next;
                prev = prev.next;
            }
            else {
                while (head.next != null && head.val == head.next.val) {
                    head.next = head.next.next;
                }
                prev.next = head.next;
                head = head.next;
            }
        }
        
        return dummy.next;
    }
}