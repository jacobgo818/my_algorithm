package go.jacob.day0605.chapter8_recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class P46_Permutations {

    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        solve(nums, 0, new ArrayList<Integer>());

        return res;
    }

    private void solve(int[] nums, int index, ArrayList<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                solve(nums, index + 1, list);
                list.remove(list.size() - 1);
                used[i]=false;//非常重要！！将状态进行回溯
            }
        }
    }
}
