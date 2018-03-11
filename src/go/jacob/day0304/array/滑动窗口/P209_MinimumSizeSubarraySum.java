package go.jacob.day0304.array.��������;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum �� s.
 * If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class P209_MinimumSizeSubarraySum {

    /*
    �������ڽⷨ
     */
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1;//ǰ�պ�� ���r��ʼ��Ϊ0�Ļ����Ͱ����˵�һ��Ԫ��
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {

            if (r + 1 < nums.length && sum < s)
                sum += nums[++r];
            else//��r���ұ߽��l��һֱ���ӵ��߽�ֵ
                sum -= nums[l++];

            if (sum >= s)
                res = Math.min(res, r - l + 1);

        }

        if (res == nums.length + 1)
            return 0;

        return res;
    }
}
