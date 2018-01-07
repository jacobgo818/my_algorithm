package go.jacob.day0107;

public class P64_MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		int[][] dp = new int[row][col];
		dp[0][0] = grid[0][0];

		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}

		for (int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}

		for (int i = 1; i < row; i++)
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}

		return dp[row - 1][col - 1];
	}
	
	/*
	 * һˢ
	 */
	public int minPathSum1(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 1; i < m; i++) {
			grid[i][0] = grid[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < n; i++) {
			grid[0][i] = grid[0][i] + grid[0][i - 1];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = (grid[i - 1][j] < grid[i][j - 1] ? grid[i - 1][j] : grid[i][j - 1]) + grid[i][j];
			}
		}

		return grid[m - 1][n - 1];
	}
}
