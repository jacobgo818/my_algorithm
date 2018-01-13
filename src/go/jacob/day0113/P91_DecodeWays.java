package go.jacob.day0113;

public class P91_DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() < 1)
			return 0;
		char[] chs = s.toCharArray();
		int[] dp = new int[s.length() + 1];
		dp[s.length()] = 1;
		dp[s.length() - 1] = chs[s.length() - 1] == '0' ? 0 : 1;
		for (int i = s.length() - 2; i >= 0; i--) {
			if (chs[i] == '0')
				continue;
			else
				dp[i] = (chs[i] - '0') * 10 + (chs[i + 1] - '0') < 27 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
		}

		return dp[0];
	}
}
