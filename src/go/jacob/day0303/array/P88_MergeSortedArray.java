package go.jacob.day0303.array;


/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class P88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums2 == null || nums2.length == 0)
            return;

        int[] tmpArr = new int[m];
        for (int i = 0; i < m; i++) {
            tmpArr[i] = nums1[i];
        }

        int index = 0;
        int i = 0, j = 0;

        while (true) {
            if (i == m || j == n)
                break;
            if (tmpArr[i] < nums2[j])
                nums1[index++] = tmpArr[i++];
            else
                nums1[index++] = nums2[j++];
        }

        while (i < m) {
            nums1[index++] = tmpArr[i++];
        }

        while (j < n) {
            nums1[index++] = nums2[j++];
        }


    }
}
