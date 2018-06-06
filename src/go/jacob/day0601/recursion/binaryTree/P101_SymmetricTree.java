package go.jacob.day0601.recursion.binaryTree;

import go.jacob.day0527.binaryTreeTraversal.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class P101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return solve(root.left, root.right);
    }

    private boolean solve(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if ((left == null && right != null) || (left != null && right == null))
            return false;
        if (left.val == right.val)
            return solve(left.left, right.right) && solve(left.right, right.left);

        return false;
    }
}