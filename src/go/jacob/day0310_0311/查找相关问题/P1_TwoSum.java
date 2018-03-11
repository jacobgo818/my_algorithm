package go.jacob.day0310_0311.�����������;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class P1_TwoSum {

    /*
    ע�⣺nums����������ģ���Ҫʹ��map�����
    �ǳ�����Ľⷨ��map����һ���Է������е�Ԫ�أ�ʹ�õ�ǰ�����Ժ��ٷ���map�����Խ�������д��ڶ��ĳ�����ֵ����
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0]=map.get(target-nums[i]);
                res[1]=i;
            }
            map.put(nums[i],i);
        }

        return res;
    }
}
