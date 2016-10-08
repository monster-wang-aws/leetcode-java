/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
    	return helper(head, null);
    }
    
    public TreeNode helper(ListNode head, ListNode end) { 
        // BST tree from head to end - 1
    	if (head == end) {
    	   return null; 
    	}
    	ListNode mid = head, fast = head; 
    	// mid is the middle point of list from head to end
    	while (fast.next != end && fast.next.next != end) {
    	    mid = mid.next;
    	    fast = fast.next.next;
    	    
    	}
    	TreeNode root = new TreeNode(mid.val);
    	root.left = helper(head, mid);
    	root.right = helper(mid.next, end);
    	return root;
    }
}