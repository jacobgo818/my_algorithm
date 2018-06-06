package go.jacob.day0605.chapter8_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class P47_PermutationsII {
    private static List<List<Integer>> res;
    private static boolean[] used;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<Integer>());

        return res;

    }

    private static void solve(int[] nums, int index, ArrayList<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!used[i] && (i == 0 || (used[i - 1] || (!used[i - 1] && nums[i] != nums[i - 1])))) {
                list.add(nums[i]);
                used[i] = true;
                solve(nums, index + 1, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res);
    }
}
