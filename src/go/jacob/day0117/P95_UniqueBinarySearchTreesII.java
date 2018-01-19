package go.jacob.day0117;

import java.util.ArrayList;
import java.util.List;

public class P95_UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		if (n <= 0)
			return null;
		List<Integer> num = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			num.add(i + 1);
		}

		List<TreeNode> res = new ArrayList<TreeNode>();
		solve(res,num);

		return res;
	}

	private void solve(List<TreeNode> res, List<Integer> num) {
		
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
