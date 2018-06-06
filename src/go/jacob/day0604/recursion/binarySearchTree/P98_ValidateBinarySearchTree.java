package go.jacob.day0604.recursion.binarySearchTree;

import go.jacob.day0527.binaryTreeTraversal.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 1   3
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 * is 5 but its right child's value is 4.
 */
public class P98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return solve(root.left, Long.MIN_VALUE, root.val) && solve(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean solve(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if ((root.val > min) && root.val < max)
            return solve(root.left, min, root.val) && solve(root.right, root.val, max);
        return false;
    }
}
