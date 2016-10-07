/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
               
        ListNode mNodeLeft = null, mNode = null, nNode = null, nNodeRight = null;
        

        int i = 0;
        for (i = 1; i < m; i++) {
            head = head.next;
        }
        mNodeLeft = head;
        mNode = head.next;
        head = head.next;
        
        for ( ; i < n; i++) {
            head = head.next;
        }
        nNode = head;
        nNodeRight = head.next;
        
        ListNode prev = nNodeRight;
        while (mNode != nNode) {
            ListNode temp = mNode.next;
            mNode.next = prev;
            prev = mNode;
            mNode = temp;
        }
        mNode.next = prev;
        mNodeLeft.next = mNode;
        
        
        return dummy.next;
    }
}