package go.jacob.day0113;

import java.util.Stack;

import org.junit.Test;

public class P84_LargestRectangleInHistogram {

	@Test
	public void testName() throws Exception {
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea(heights));
	}

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length < 1)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			if (stack.isEmpty() || stack.peek() == -1 || heights[i] >= heights[stack.peek()])
				stack.push(i);
			else {
				while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
					int index = stack.pop();
					max = Math.max(max, heights[index] * (i - 1 - stack.peek()));
				}
				stack.push(i);
			}
		}
		while (stack.peek() != -1) {
			int index = stack.pop();
			max = Math.max(max, heights[index] * (heights.length - 1-stack.peek()));
		}

		return max;

	}
}
