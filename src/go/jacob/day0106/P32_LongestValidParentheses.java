package go.jacob.day0106;


import org.junit.Test;

import java.util.Stack;

public class P32_LongestValidParentheses {

	@Test
	public void testName() throws Exception {
		System.out.println(longestValidParentheses("(()()"));
	}

	/*
	 * 非动态规划，有时候会超时
	 */
	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 1)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0, left = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push(i);
			else {
				if (!stack.isEmpty()) {
					stack.pop();
					if (!stack.isEmpty())
						max = Math.max(max, i - stack.peek());
					else
						max = Math.max(max, i - left);
				} else
					left = i;
			}
		}
		return max;
	}

	/*
	 * 动态规划
	 */
	public int longestValidParentheses1(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}

	// ==========================测试====================================
	// Your runtime beats 92.48 % of java submissions.
	public int longestValidParentheses2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int[] dp = new int[s.length()];
		int ans = 0;
		for (int i = 1; i < s.length(); i++) {
			// 如果是'('直接跳过，默认为0
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(')
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				// 说明s.charAt(i - 1)==')'
				else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = (i - dp[i - 1] > 1 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
					// 因为加了一个左括号和一个右括号，所以是加2
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
}
