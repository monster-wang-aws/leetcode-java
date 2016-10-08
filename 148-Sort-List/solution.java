/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }

        ListNode l2 = sortList(mid.next);
        mid.next = null;
        head = sortList(head);
        return merge(l2, head);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode curt = l3;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curt.next = l1;
                l1 = l1.next;
            }
            else {
                curt.next = l2;
                l2 = l2.next;
            }
            curt = curt.next;
        }
        if (l1 != null) {
            curt.next = l1;
        }
        else {
            curt.next = l2;
        }

        return l3.next;
    }
}