package go.jacob.day0106;

public class P63_UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1)
			return 0;
		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = 1;
		for (int i = 1; i < row; i++)
			if (obstacleGrid[i][0] != 1)
				dp[i][0] = dp[i - 1][0];
			else
				break;

		for (int j = 1; j < col; j++)
			if (obstacleGrid[0][j] != 1)
				dp[0][j] = dp[0][j - 1];
			else
				break;

		for (int i = 1; i < row; i++)
			for (int j = 1; j < col; j++)
				if (obstacleGrid[i][j] == 1)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

		return dp[row - 1][col - 1];
	}

	public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		obstacleGrid[0][0] ^= 1;

		for (int i = 1; i < m; i++) {
			obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
		}

		for (int i = 1; i < n; i++) {
			obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
			}
		}
		return obstacleGrid[m - 1][n - 1];
	}
}
