package go.jacob.day0108;

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
//					System.out.println("curHeight=" + curHeight + " curArea=" + curArea);
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
