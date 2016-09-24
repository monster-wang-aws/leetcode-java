/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

class Rst {
    int singlePath, maxPath;
    
    Rst(int singlePath, int maxPath) {
        this.singlePath = singlePath;
        this.maxPath = maxPath;
    }
}
 
public class Solution {

    public int maxPathSum(TreeNode root) {
        Rst rst = helper(root);
        return rst.maxPath;
    }
    
    public Rst helper(TreeNode root) {
        if (root == null) {
            return new Rst(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        
        Rst left = helper(root.left);
        Rst right = helper(root.right);
        
        int singlePath = Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, Math.max(0, left.singlePath) + root.val + Math.max(0, right.singlePath));
        
        return new Rst(singlePath, maxPath);
    }
    
}