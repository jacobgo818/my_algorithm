package go.jacob.day0108;

import org.junit.Test;

public class FibonacciSequence {
	@Test
	public void testName() throws Exception {
		System.out.println(f3(34));
	}

	/*
	 * 循环解法
	 */
	public int f2(int n) {
		if (n < 1)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int res = 0;
		int pre1 = 1;
		int pre2 = 1;
		for (int i = 3; i <= n; i++) {
			res = pre1 + pre2;
			pre2 = pre1;
			pre1 = res;
		}

		return res;
	}

	public int f3(int n) {
		if (n < 1)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int[][] base = { { 1, 1 }, { 1, 0 } };
		int[][] res = matrixPower(base, n - 2);

		return res[0][0] + res[1][0];
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

}
