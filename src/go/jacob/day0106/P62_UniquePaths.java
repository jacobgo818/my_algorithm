package go.jacob.day0106;

import java.util.Arrays;

public class P62_UniquePaths {
	public int uniquePaths(int m, int n) {
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j]+=dp[j-1];
			}
		}

		return dp[n-1];
	}
	/*
	 * һˢ
	 */
	public int uniquePaths1(int m, int n) {
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++)
			res[i][0] = 1;
		for (int i = 0; i < n; i++)
			res[0][i] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++)
					res[i][j] = res[i - 1][j] + res[i][j - 1];
		}
		return res[m - 1][n - 1];
	}
}
