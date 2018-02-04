package go.jacob.day0120;

public class P97_InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		boolean[][] res = new boolean[s1.length() + 1][s2.length() + 1];
		res[0][0] = true;
		for (int i = 0; i < s1.length(); i++) {
			res[i + 1][0] = res[i][0] && s1.charAt(i) == s3.charAt(i);
		}
		for (int j = 0; j < s2.length(); j++) {
			res[0][j + 1] = res[0][j] && s2.charAt(j) == s3.charAt(j);
		}
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				res[i + 1][j + 1] = (res[i][j + 1] && s1.charAt(i) == s3.charAt(i + j + 1)
						|| (res[i + 1][j] && s2.charAt(j) == s3.charAt(i + j + 1)));
			}
		}
		return res[s1.length()][s2.length()];
	}
}
