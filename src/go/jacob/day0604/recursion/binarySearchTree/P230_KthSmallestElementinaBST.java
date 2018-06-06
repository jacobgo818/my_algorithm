package go.jacob.day0604.recursion.binarySearchTree;

import apple.laf.JRSUIUtils;
import com.sun.corba.se.impl.orbutil.StackImpl;
import go.jacob.day0527.binaryTreeTraversal.TreeNode;

import java.util.Stack;

/**
 * Given a binary search tree,
 * write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often
 * and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * 解法：
 * 二叉搜索树的中序遍历，就是从小到大排序
 */
public class P230_KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur == null) {
                cur = stack.pop();
                if (--k == 0)
                    return cur.val;
                cur = cur.right;
                continue;
            }
            stack.push(cur);
            cur = cur.left;
        }

        return 0;
    }
}
