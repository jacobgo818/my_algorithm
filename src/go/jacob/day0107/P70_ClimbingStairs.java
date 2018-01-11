package go.jacob.day0107;

import static org.junit.Assert.*;

import org.junit.Test;

public class P70_ClimbingStairs {
	
	@Test
	public void testName() throws Exception {
		System.out.println(climbStairs(105));
	}
	/*
	 * 动态规划解法
	 */
	public int climbStairs3(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int[][] base = { { 1, 1 }, { 1, 0 } };
		int[][] res = matrixPower(base, n - 2);

		return 2*res[0][0] + res[1][0];
	}
	
	
	/*
	 * 求矩阵m的p次方
	 */
	public int[][] matrixPower(int[][] m, int p) {
		int[][] res = new int[m.length][m[0].length];
		// 把res设为单位矩阵，相当于整数中的1；
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}

		int[][] tmp = m;
		for (; p != 0; p >>= 1) {
			if ((p & 1) != 0)
				res = muliMatrix(res, tmp);
			tmp = muliMatrix(tmp, tmp);
		}
		return res;
	}

	/*
	 * 两个矩阵相乘
	 */
	private int[][] muliMatrix(int[][] m1, int[][] m2) {
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}
	
	
	public int climbStairs(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int oneStepBefore = 2;
		int twoStepsBefore = 1;
		int allWays = 0;
		
		for(int i=3;i<=n;i++){
			allWays=oneStepBefore+twoStepsBefore;
			twoStepsBefore=oneStepBefore;
			oneStepBefore=allWays;
		}
		return allWays;
	}

	public int climbStairs1(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int one_step_before = 2;
		int two_steps_before = 1;
		int all_ways = 0;

		for (int i = 2; i < n; i++) {
			all_ways = one_step_before + two_steps_before;
			two_steps_before = one_step_before;
			one_step_before = all_ways;
		}
		return all_ways;
	}
}
