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
        return String.valueOf(root.val) + " " + serialize(root.left) + " " + serialize(root.right);
    }

    int desPos;

    public TreeNode deserialize(String data) {
        desPos = -1;
        return desHelper(data.split(" "));
    }

    private TreeNode desHelper(String[] strs) {
        desPos++;
        if (strs[desPos].equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[desPos]));
        node.left = desHelper(strs);
        node.right = desHelper(strs);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));