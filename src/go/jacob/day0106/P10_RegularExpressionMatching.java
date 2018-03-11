package go.jacob.day0106;


import org.junit.Test;

/*
 * 不知道匹配机制是什么
 * ab .*居然也能通过
 */
public class P10_RegularExpressionMatching {

	@Test
	public void testName() throws Exception {
		System.out.println(isMatch("bboiuouccnnpiopn", "bboi.*"));
	}

	public boolean isMatch1(String s, String p) {
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return false;
		int row = s.length();
		int col = p.length();
		boolean[][] dp = new boolean[row + 1][col + 1];
		dp[0][0] = true;
		for (int j = 0; j < col; j++) {
			if (p.charAt(j) == '*')
				dp[0][j + 1] = dp[0][j - 1];
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (p.charAt(j) == '.')
					dp[i + 1][j + 1] = dp[i][j];
				else if (p.charAt(j) == s.charAt(i))
					dp[i + 1][j + 1] = dp[i][j];
				else if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
						dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
					} else
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
				}
			}
		}
		return dp[row][col];
	}

	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
		res[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*')
				res[0][i + 1] = res[0][i - 1];
		}

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '.')
					res[i + 1][j + 1] = res[i][j];
				if (p.charAt(j) == s.charAt(i))
					res[i + 1][j + 1] = res[i][j];
				if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
						res[i + 1][j + 1] = res[i + 1][j] || res[i + 1][j - 1] || res[i][j + 1];
					} else
						res[i + 1][j + 1] = res[i + 1][j - 1];
				}
			}
		}

		return res[s.length()][p.length()];
	}
}
