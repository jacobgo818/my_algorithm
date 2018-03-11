package go.jacob.day0303.array;

public class P215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, target = nums.length - k;
        int index;
        while (start < end) {
            index = partition(nums, start, end);
            if (target > index)
                start = index + 1;
            else if (target < index)
                end = index - 1;
            else
                return nums[index];
        }


        return nums[start];
    }

    private int partition(int[] a, int left, int right) {
        int i = left, j = right + 1;
        int tmp = a[left];

        while (i < j) {
            while (a[++i] < tmp) {
                if (i == right)
                    break;
            }
            while (a[--j] > tmp) {
                if (j == left)
                    break;
            }
            if (i >= j)
                break;
            exch(a, i, j);
        }

        exch(a, j, left);

        return j;

    }

    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
