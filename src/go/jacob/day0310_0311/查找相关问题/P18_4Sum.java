package go.jacob.day0310_0311.查找相关问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c,
 * and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class P18_4Sum {
    /*
    O(n^3)
    基于P15_3Sum
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 4)
            return res;

        Arrays.sort(nums);
        int l, r;
        int sum;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                l = j + 1;
                r = nums.length - 1;
                while (l < r) {
                    sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[l], nums[r])));
                        while(l+1<r&&nums[l]==nums[l+1])
                            l++;
                        while(r-1>l&&nums[r]==nums[r-1])
                            r--;
                        l++;
                        r--;
                    }else if(sum>target)
                        r--;
                    else
                        l++;
                }
            }

        }
        return res;

    }
}
