package go.jacob.day0303.array;


/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class P283_MoveZeros {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != index)
                    swap(nums, i, index++);
                else
                    index++;
            }
        }

    }

    private void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*
    不需要额外空间
    时间O（n）
    空间O（1）
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

    }


    /*
    使用了辅助空间
    时间O（n）
    空间O（n）
     */
    public void moveZeroes1(int[] nums) {
        int[] nonZeroElements = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nonZeroElements[index++] = nums[i];


        for (int i = 0; i < index; i++)
            nums[i] = nonZeroElements[i];

        for (int i = index; i < nums.length; i++)
            nums[i] = 0;

    }

}
