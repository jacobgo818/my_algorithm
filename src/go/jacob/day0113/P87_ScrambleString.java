package go.jacob.day0113;


import org.junit.Test;

/*
 * 1.只能交换非叶节点的两个字节点，不能任意交换节点
 * 2.一个字符串的左子树字符数和右子树字符数是任意的
 */
public class P87_ScrambleString {

	@Test
	public void testName() throws Exception {
		System.out.println(isScramble("great","rgeat"));
	}
	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		
		int[] letters = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			letters[s1.charAt(i) - 'a']++;
			letters[s2.charAt(i) - 'a']--;
		}
		
		for (int i = 0; i < 26; i++)
			if (letters[i] != 0)
				return false;

		for (int i = 1; i < s1.length(); i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) 
					&& isScramble(s1.substring(i), s2.substring(i)))
				return true;
			if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
					&& isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
				return true;
		}

		return false;
	}
}
