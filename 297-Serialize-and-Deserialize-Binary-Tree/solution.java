/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
     
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        else {
            return String.valueOf(root.val) + " " + serialize(root.left) + " " + serialize(root.right);
        }
    }
    
    int pos = -1;
    public TreeNode deserialize(String data) {
        return helper(data.split(" "));
    }
    
    public TreeNode helper(String[] data) {
        pos++;
        if (data[pos].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[pos]));
        root.left = helper(data);
        root.right = helper(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));