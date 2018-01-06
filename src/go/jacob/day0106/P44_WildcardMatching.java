package go.jacob.day0106;

public class P44_WildcardMatching {
	/*
	 * ¶þË¢
	 */
	public boolean isMatch(String s, String p) {
		int row = s.length();
		int col = p.length();
		boolean[][] dp = new boolean[row + 1][col + 1];
		dp[0][0] = true;
		for (int j = 1; j < col + 1; j++) {
			if (dp[0][j - 1]) {
				if (p.charAt(j - 1) == '*')
					dp[0][j] = true;
				else
					break;
			}
		}
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')
					dp[i + 1][j + 1] = dp[i][j];
				else if (p.charAt(j) == '*') {
					dp[i + 1][j + 1] = dp[i][j] || dp[i + 1][j] || dp[i][j + 1];
				}
			}

		return dp[row][col];
	}

	/*
	 * Ò»Ë¢´ð°¸
	 */
	public boolean isMatch1(String s, String p) {
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[s.length()][p.length()] = true;
		for (int i = p.length() - 1; i >= 0; i--) {
			if (p.charAt(i) != '*')
				break;
			else
				match[s.length()][i] = true;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = p.length() - 1; j >= 0; j--) {
				if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
					match[i][j] = match[i + 1][j + 1];
				else if (p.charAt(j) == '*')
					match[i][j] = match[i + 1][j] || match[i][j + 1];
				else
					match[i][j] = false;
			}
		}
		return match[0][0];
	}
}
