package go.jacob.day0601.recursion.binaryTree;

import go.jacob.day0527.binaryTreeTraversal.TreeNode;

/**
 * Invert a binary tree.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * Output:
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * <p>
 * Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can¡¯t invert a binary tree on a whiteboard so f*** off.
 */
public class P226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        solve(root);
        return root;
    }

    private void solve(TreeNode root) {
        if (root == null)
            return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        solve(root.left);
        solve(root.right);

    }
}
