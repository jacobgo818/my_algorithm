package go.jacob.day0602.recursion;

import go.jacob.day0527.binaryTreeTraversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * Output: ["1->2->5", "1->3"]
 * <p>
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class P257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null)
            return res;
        solve(root, res, "");
        return res;
    }

    private void solve(TreeNode root, List<String> res, String s) {
        if (s.equals(""))
            s += root.val;
        else
            s = s + "->" + root.val;
        if (root.left == null && root.right == null) {
            res.add(s);
            return;
        }
        if (root.left != null)
            solve(root.left, res, s);
        if (root.right != null)
            solve(root.right, res, s);
    }
}
