package go.jacob.day0117;

import java.util.ArrayList;
import java.util.List;

public class P95_UniqueBinarySearchTreesII {
	@SuppressWarnings("unchecked")
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode>[] res = new List[n + 1];
		res[0] = new ArrayList<TreeNode>();
		if (n <= 0)
			return res[0];
		//必须add(null)，否则for (TreeNode left : res[0])会报错
		res[0].add(null);
		for (int i = 1; i <= n; i++) {
			res[i] = new ArrayList<TreeNode>();
			for (int j = 1; j <= i; j++) {
				for (TreeNode left : res[j - 1]) {
					for (TreeNode right : res[i - j]) {
						TreeNode root = new TreeNode(j);
						root.left = left;
						root.right = clone(right, j);
						res[i].add(root);
					}
				}
			}
		}
		return res[n];
	}

	private TreeNode clone(TreeNode node, int offset) {
		if (node == null)
			return null;
		TreeNode root = new TreeNode(node.val + offset);
		root.left = clone(node.left, offset);
		root.right = clone(node.right, offset);
		return root;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
