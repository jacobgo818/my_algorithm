package go.jacob.day0527.binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ����һ���������������������� ������
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
 * ���: [1,3,2]
 * ����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����
 * <p>
 * �ⷨ��
 * ������������Ϊ�ݹ�ͷǵݹ�汾������Ҫ���գ�
 * ������ƫ�����ʷǵݹ�ʵ��
 */
public class P94_BinaryTreeInorderTraversal {
    /*
    �ݹ�ʵ�֣�����ܼ�
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
    �ǵݹ�ʵ��
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













