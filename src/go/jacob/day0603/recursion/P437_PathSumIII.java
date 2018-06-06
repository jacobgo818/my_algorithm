package go.jacob.day0603.recursion;

import go.jacob.day0527.binaryTreeTraversal.TreeNode;

/**
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class P437_PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int res = 0;

        res += findPath(root, sum);
        res += pathSum(root.left, sum) + pathSum(root.right, sum);

        return res;
    }

    private int findPath(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int res = 0;
        if (root.val == sum)
            res += 1;
        res += findPath(root.left, sum - root.val) + findPath(root.right, sum - root.val);

        return res;

    }
}
