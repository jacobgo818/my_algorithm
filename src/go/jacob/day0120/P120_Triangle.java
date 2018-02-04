package go.jacob.day0120;

import java.util.ArrayList;
import java.util.List;

public class P120_Triangle {
	/*
	 * O(n)空间复杂度
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int rows = triangle.size();
		int[] pre = new int[rows];
		int[] cur = new int[rows];
		pre[0] = triangle.get(0).get(0);
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j <= i; j++) {
				int num = triangle.get(i).get(j);
				int min = Math.min(j - 1 >= 0 ? pre[j - 1] : pre[j], j == i ? pre[j - 1] : pre[j]);
				cur[j] = num + min;
			}
			int[] tmp = pre;
			pre = cur;
			cur = tmp;
		}
		int min = pre[0];
		for (int i = 1; i < rows; i++)
			if (pre[i] < min)
				min = pre[i];
		return min;
	}
	
	/*
	 * 从下往上遍历，不需要额外空间
	 */
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int rows = triangle.size();
		for (int i = rows - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
				triangle.get(i).set(j, triangle.get(i).get(j) + min);
			}
		}
		return triangle.get(0).get(0);
	}

	/*
	 * O(n^2)空间复杂度
	 */
	public int minimumTotal1(List<List<Integer>> triangle) {
		int rows = triangle.size();
		int[][] res = new int[rows][rows];
		res[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j <= i; j++) {
				int num = triangle.get(i).get(j);
				int min = Math.min(j - 1 >= 0 ? res[i - 1][j - 1] : res[i - 1][j],
						j == i ? res[i - 1][j - 1] : res[i - 1][j]);
				res[i][j] = num + min;
			}
		}
		int min = res[rows - 1][0];
		for (int i = 1; i < rows; i++)
			if (res[rows - 1][i] < min)
				min = res[rows - 1][i];
		return min;
	}
}
