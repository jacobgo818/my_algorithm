package go.jacob.day0303.array;

import java.util.ArrayList;

public class BinarySearch {
    public static int binarySearch(int[] arr, int n, int target) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return -1;//ц╩спур╣╫
    }

    private static int[] getArr(int n){
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
        }
        return arr;
    }

    public static void main(String[] args) {
        int a=binarySearch(getArr(10000),10000,7856);
        System.out.println(a);
        new ArrayList<String>();
    }
}
