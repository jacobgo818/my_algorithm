package go.jacob.day0325.leetcode;

import java.util.*;

/**
 * ����һ�����������һ������ k���ж��������Ƿ����������ͬ������ i �� j��
 * ʹ nums [i] = nums [j]������ i �� j �ľ��Բ�ֵ���Ϊ k��
 */
public class P219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k)
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
