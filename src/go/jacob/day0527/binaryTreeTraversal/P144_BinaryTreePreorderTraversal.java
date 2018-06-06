package go.jacob.day0527.binaryTreeTraversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
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
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 解法：
 * 二叉树遍历分为递归和非递归版本（都需要掌握）
 * 面试中偏向于问非递归实现
 */
public class P144_BinaryTreePreorderTraversal {
    /*
    递归实现，代码很简单
     */
    public static List<Integer> preorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);

        return res;
    }

    private static void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    /*
    非递归实现，重点掌握
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        res.add(root.val);
        TreeNode cur = root.left;

        while (!stack.isEmpty() || cur != null) {
            if (cur == null) {
                cur = stack.pop().right;
                continue;
            }
            res.add(cur.val);
            stack.push(cur);
            cur = cur.left;

        }
        return res;
    }


}
