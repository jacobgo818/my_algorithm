package go.jacob.day0323.toutiao;

import java.util.Arrays;
import java.util.Scanner;

public class Demo6 {
    public static void main(String[] args) {
        System.out.println(8);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int H = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int high = 0;
        int index = -1;
        for (int i = 0; i < K; i++) {
            while (index + 1 < arr.length && arr[index + 1] - high < H)
                index++;
            if (arr[index] - high < H) {
                high = high + (arr[index] - high) * 2;
            }
        }
        System.out.println(high);


    }
}
