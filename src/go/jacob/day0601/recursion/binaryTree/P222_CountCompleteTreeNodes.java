package go.jacob.day0601.recursion.binaryTree;

import go.jacob.day0527.binaryTreeTraversal.TreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * Output: 6
 * <p>
 * 解题思路：
 * 1、获得二叉树的高度h
 * 2、获得右子树的高度m
 * 3、判断：如果m=h-1，说明root.left是满二叉树，那么root加上左子树的个数就是2^h，然后递归root.right
 * 4、如果m不等于h-1，说明root.right是满二叉树，只是有少了一层，那么右子树加上root的个数就是2^(h-1),然后递归root.left
 */
public class P222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int h = height(root);
        int num = 0;

        int rh = height(root.right);
        if (rh == -1)
            num += 1 << h;
        else if (rh == h - 1)
            num += (1 << h) + countNodes(root.right);
        else
            num += (1 << (h - 1)) + countNodes(root.left);

        return num;

    }

    public int height(TreeNode root) {
        if (root == null)
            return -1;
        return 1 + height(root.left);
    }
}
