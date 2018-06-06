package go.jacob.day0527.binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P145_BinaryTreePostorderTraversal {

    /*
    �ݹ�ʵ�֣�����ܼ�
     */
    public List<Integer> postorderTraversal_1(TreeNode root) {
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
        helper(root.right, res);
        res.add(root.val);
    }

    /*
    �ǵݹ�ʵ��
    ����˼·��ʹ������ջ
    stack1��Stack2����push�С��ҡ���ڵ㣨�ݹ飩
    Ψһ�����ǣ�stack2��pop�ڵ�
    ���˳���ӡstack2�еĽڵ㼴��
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack1.isEmpty()) {
            if (cur == null) {
                cur = stack1.pop();
                cur = cur.left;
                continue;
            }
            stack1.push(cur);//һ��push
            stack2.push(cur);
            cur = cur.right;
        }

        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }

        return res;
    }
}
