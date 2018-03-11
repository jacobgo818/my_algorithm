package go.jacob.day0310_0311.查找相关问题;

import java.util.HashSet;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * <p>
 * 题意：找到两个数组中的共同元素
 */
public class P349_IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> record = new HashSet<Integer>();
        HashSet<Integer> resultSet = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++)
            record.add(nums1[i]);

        for (int i = 0; i < nums2.length; i++)
            if (record.contains(nums2[i]))
                resultSet.add(nums2[i]);

        int[] res = new int[resultSet.size()];
        int index = 0;
        for (Integer e : resultSet)
            res[index++] = e;

        return res;

    }
}
