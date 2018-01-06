package go.jacob.day0106;

public class P53_MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int maxEndingHere = 0;
		int maxSoFar = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			maxEndingHere += nums[i];
			if (maxEndingHere > maxSoFar)
				maxSoFar = maxEndingHere;
			if (maxEndingHere < 0)
				maxEndingHere = 0;
		}
		return maxSoFar;
	}
}
