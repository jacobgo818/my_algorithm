package go.jacob.day0303.array;

public class P80_RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;

        int index = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[index - 1] && nums[i] == nums[index - 2])
                continue;
            if (i != index)
                nums[index++] = nums[i];
            else
                index++;
        }

        return index;
    }

}
