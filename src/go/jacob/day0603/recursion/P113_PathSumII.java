package go.jacob.day0603.recursion;

import go.jacob.day0527.binaryTreeTraversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum,
 * find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * Return:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class P113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        List<Integer> list = new ArrayList<Integer>();
        solve(root, sum, res, list);

        return res;
    }

    private void solve(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(list));
        }

        if (root.left != null) {
            solve(root.left, sum - root.val, res, list);
        }
        if (root.right != null) {
            solve(root.right, sum - root.val, res, list);
        }
        list.remove(list.size() - 1);
    }
}
















