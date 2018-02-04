package go.jacob.day0120;

public class P115_DistinctSubsequences {
	public int numDistinct(String s, String t) {
		if (s == null || t == null)
			return 0;
		int[][] res = new int[s.length() + 1][t.length() + 1];

		for (int i = 0; i < s.length() + 1; i++)
			res[i][0] = 1;

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < t.length(); j++) {
				if (s.charAt(i) == t.charAt(j))
					res[i + 1][j + 1] = res[i][j] + res[i][j + 1];
				else
					res[i + 1][j + 1] = res[i][j + 1];
			}
		}
		return res[s.length()][t.length()];
	}
}
