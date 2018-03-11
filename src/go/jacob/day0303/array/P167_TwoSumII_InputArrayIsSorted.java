package go.jacob.day0303.array;

import org.junit.Test;

/**
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * <p>
 * <p>
 * <p>
 * 解法一：用的是二分查找
 * <p>
 * 解法二：用两个指针，i=0,j=numbers.length sum>target j--   sum<target  i++
 */
public class P167_TwoSumII_InputArrayIsSorted {

    /*
    解法一
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                int[] res = {l + 1, r + 1};
                return res;
            } else if (numbers[l] + numbers[r] > target)
                r--;
            else
                l++;
        }
        throw new RuntimeException("The input has no solution");
    }

    /*
    解法二
     */
    public int[] twoSum1(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;
        int[] res = new int[2];
        int index;
        for (int i = 0; i < numbers.length; i++) {
            index = binarySearch(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if (index != -1) {
                res[0] = i + 1;
                res[1] = index + 1;
                return res;
            }
        }

        return res;
    }

    private int binarySearch(int[] arr, int k, int start, int end) {
        int mid;
        int left = start, right = end;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > k)
                right = mid - 1;
            else if (arr[mid] < k)
                left = mid + 1;
            else
                return mid;
        }

        return -1;

    }

    @Test
    public void test1() {
        int[] arr = {2, 3, 4};


        int[] res = twoSum(arr, 6);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }


}
