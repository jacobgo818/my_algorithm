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
 * ����˼·��
 * 1����ö������ĸ߶�h
 * 2������������ĸ߶�m
 * 3���жϣ����m=h-1��˵��root.left��������������ôroot�����������ĸ�������2^h��Ȼ��ݹ�root.right
 * 4�����m������h-1��˵��root.right������������ֻ��������һ�㣬��ô����������root�ĸ�������2^(h-1),Ȼ��ݹ�root.left
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
