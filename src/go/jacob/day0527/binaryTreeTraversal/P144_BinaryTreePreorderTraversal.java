package go.jacob.day0527.binaryTreeTraversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ����һ������������������ ǰ�� ������
 * <p>
 * ʾ��:
 * <p>
 * ����: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * ���: [1,2,3]
 * ����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����
 * <p>
 * �ⷨ��
 * ������������Ϊ�ݹ�ͷǵݹ�汾������Ҫ���գ�
 * ������ƫ�����ʷǵݹ�ʵ��
 */
public class P144_BinaryTreePreorderTraversal {
    /*
    �ݹ�ʵ�֣�����ܼ�
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
    �ǵݹ�ʵ�֣��ص�����
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
