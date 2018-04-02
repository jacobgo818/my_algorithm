package go.jacob.day0323.toutiao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Demo2 {


    /*
    80%
     */
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<Integer>();

        int n = in.nextInt();
        int k = in.nextInt();
        int[] numArray = new int[n];
        for (int i = 0; i < n; i++) {
            numArray[i] = in.nextInt();
            set.add(numArray[i]);
        }
        int count = 0;
        Arrays.sort(numArray);
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] + k > numArray[n - 1])
                break;
            if (i > 0 && numArray[i] == numArray[i - 1]) {
                continue;
            }

            if (set.contains(numArray[i] + k)) {
                count++;
            }
        }
        System.out.println(count);

    }
}
