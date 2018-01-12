package go.jacob.day0108;

import java.util.Stack;

import org.junit.Test;

public class P85_MaximalRectangle {
	@Test
	public void testName() throws Exception {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println(maximalRectangle(matrix));
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length < 1)
			return 0;
		int[] heights = new int[matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0')
					heights[j] = 0;
				else
					heights[j]++;
			}
			max = Math.max(max, largestRectangleArea(heights));
		}
		return max;
	}

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length < 1)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int max = heights[0];
		for (int i = 0; i < heights.length; i++) {
			if (stack.isEmpty() || stack.peek() == -1 || heights[stack.peek()] <= heights[i])
				stack.push(i);
			else {
				int curHeight = 0;
				int curArea = 0;
				while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
					curHeight = heights[stack.pop()];
					curArea = curHeight * (i - 1 - stack.peek());
					max = Math.max(max, curArea);
				}
				stack.push(i);
			}
		}
		while (stack.peek() != -1) {
			int top = stack.pop();
			max = Math.max(max, (heights.length - 1 - stack.peek()) * heights[top]);
		}
		return max;
	}
}
