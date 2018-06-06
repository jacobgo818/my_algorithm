package go.jacob.day0604.recursion.binarySearchTree;

import go.jacob.day0527.binaryTreeTraversal.TreeNode;

/**
 * Given a root node reference of a BST and a key,
 * delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 * <p>
 * Example:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * <p>
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * Another valid answer is [5,2,6,null,4,null,7].
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 * <p>
 * 解题：
 * 在二分搜索树上删除节点，是搜索树中最难的操作
 * 首先找到要删除的节点node，然后分情况讨论
 * 1.node左右子树都为空，直接删除
 * 2.node左右子树中有一个节点为空，访问另一个子节点
 * 3。都不为空，将右子树中的最小节点替换当前node，然后递归删除右子树中的最小节点。
 */
public class P450_DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else {
            if (root.right == null)
                return root.left;
            else if (root.left == null)
                return root.right;

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root;
    }


}
