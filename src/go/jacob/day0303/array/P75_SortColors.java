package go.jacob.day0303.array;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class P75_SortColors {

    /*
    桶排序
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int[] count = new int[3];

        for (int i = 0; i < nums.length; i++) {
            assert (nums[i] >= 0 && nums[i] <= 2);
            count[nums[i]]++;
        }

        int index = 0;

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    /*
    三路快排方式
     */
    public void sortColors1(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        //明确zero和two变量的定义
        int zero = -1;//nums[0...zero]=0
        int two = nums.length;//nums[two...n-1]==2

        for (int i = 0; i < two; ) {
            if (nums[i] == 0)
                exch(nums, i++, ++zero);
            else if (nums[i] == 2)
                exch(nums, i, --two);
            else {
                assert (nums[i] == 1);
                i++;
            }
        }
    }


    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
