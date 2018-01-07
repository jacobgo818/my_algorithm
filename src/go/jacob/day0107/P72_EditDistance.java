package go.jacob.day0107;

public class P72_EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null)
			return -1;
		int row = word1.length();
		int col = word2.length();

		int[][] dp = new int[row + 1][col + 1];

		for (int i = 1; i < row + 1; i++) {
			dp[i][0] = i;
		}

		for (int j = 1; j < col + 1; j++) {
			dp[0][j] = j;
		}
		int min = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				min = Math.min(dp[i][j + 1], dp[i + 1][j]) + 1;
				if (word1.charAt(i) == word2.charAt(j))
					min = Math.min(min, dp[i][j]);
				else
					min = Math.min(min, dp[i][j] + 1);
				dp[i + 1][j + 1] = min;
			}
		}
		return dp[row][col];
	}

	public int minDistance1(String word1, String word2) {
		if (word1 == null || word2 == null)
			return 0;
		int[][] res = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			res[i][0] = i;
		}
		for (int j = 0; j <= word2.length(); j++) {
			res[0][j] = j;
		}

		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				if (word1.charAt(i) == word2.charAt(j))
					res[i + 1][j + 1] = res[i][j];
				else {
					res[i + 1][j + 1] = 1 + min(res[i + 1][j], res[i][j + 1], res[i][j]);
				}
			}
		}

		return res[word1.length()][word2.length()];
	}

	private int min(int i, int j, int k) {
		int min = Math.min(i, j);
		min = Math.min(min, k);
		return min;
	}
}
