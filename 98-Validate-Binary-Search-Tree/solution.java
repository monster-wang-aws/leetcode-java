/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Rst {
    boolean is_bst;
    int maxValue;
    int minValue;
    
    Rst(boolean is_bst, int maxValue, int minValue) {
        this.is_bst = is_bst;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
} 

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Rst rst = helper(root);
        return rst.is_bst;
    }
    
    public Rst helper(TreeNode root) {
        if (root == null) {
            return new Rst(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        // if (!isValidBST(root.left) || !isValidBST(root.right)) {
        //     // System.out.println(1);
        //     return new Rst(false, 0, 0);
        // }
        
        Rst left = helper(root.left);
        Rst right = helper(root.right);
        
        if (!left.is_bst || !right.is_bst) {
            return new Rst(false, 0, 0);
        }
        else if (root.left != null && left.maxValue >= root.val ||
            root.right != null && right.minValue <= root.val) {
            // System.out.println("??"); 
            return new Rst(false, 0, 0);
        }
        // System.out.println(root.val + " " + Math.max(left.maxValue, root.val) + " " + Math.min(right.minValue, root.val)); 
        System.out.println(root.val + " " + left.maxValue + " " + right.minValue); 
        return new Rst(true, Math.max(right.maxValue, root.val), Math.min(left.minValue, root.val));
    }
}