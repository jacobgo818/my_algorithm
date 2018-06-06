package go.jacob.day0604.recursion.binarySearchTree;

import go.jacob.day0527.binaryTreeTraversal.TreeNode;

/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * <p>
 * For this problem,
 * a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class P108_ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        TreeNode root = solve(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode solve(int[] nums, int left, int right) {
        if (right < left)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = solve(nums, left, mid - 1);
        root.right = solve(nums, mid + 1, right);

        return root;
    }
}
