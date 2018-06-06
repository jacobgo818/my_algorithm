package go.jacob.day0527.binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 解法：
 * 二叉树遍历分为递归和非递归版本（都需要掌握）
 * 面试中偏向于问非递归实现
 */
public class P94_BinaryTreeInorderTraversal {
    /*
    递归实现，代码很简单
     */
    public List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    /*
    非递归实现
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode cur = root.left;

        while (!stack.isEmpty() || cur != null) {
            if (cur == null) {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
                continue;
            }
            stack.push(cur);
            cur = cur.left;

        }
        return res;
    }
}













