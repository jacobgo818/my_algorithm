package go.jacob.day0409.jd;

import java.util.Scanner;

public class Demo2 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            long[] arr = new long[t];
            for (int i = 0; i < t; i++)
                arr[i] = sc.nextLong();

            for (int i = 0; i < t; i++) {
                if (arr[i] % 2 == 0) {
                    long a = arr[i] / 2;
                    long b = 2;
                    while (a % 2 == 0) {
                        a = a / 2;
                        b *= 2;
                    }
                    System.out.println(a + " " + b);
                } else
                    System.out.println("No");
            }
        }

    }
}
