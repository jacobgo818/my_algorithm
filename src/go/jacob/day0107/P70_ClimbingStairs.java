package go.jacob.day0107;

public class P70_ClimbingStairs {
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
