package go.jacob.day0304.array.滑动窗口;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class P209_MinimumSizeSubarraySum {

    /*
    滑动窗口解法
     */
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1;//前闭后闭 如果r初始化为0的话，就包含了第一个元素
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {

            if (r + 1 < nums.length && sum < s)
                sum += nums[++r];
            else//当r到右边界后，l会一直增加到边界值
                sum -= nums[l++];

            if (sum >= s)
                res = Math.min(res, r - l + 1);

        }

        if (res == nums.length + 1)
            return 0;

        return res;
    }
}
