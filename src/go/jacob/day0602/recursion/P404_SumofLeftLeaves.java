package go.jacob.day0602.recursion;

import go.jacob.day0527.binaryTreeTraversal.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class P404_SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int res = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                res += root.left.val;
            else
                res += sumOfLeftLeaves(root.left);
        }

        res += sumOfLeftLeaves(root.right);

        return res;
    }
}
