package go.jacob.day0409.jd;

import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        long[][] dp = new long[len][len];

        for (int j = 0; j < len; j++) {
            dp[j][j] = 1;
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] += 1 + dp[i + 1][j - 1];
            }


            System.out.println(dp[0][len - 1]);
        }
    }

    public static int solve(String str) {
        int len = str.length();
        int[][] dp = new int[len][len];

        for (int j = 0; j < len; j++) {
            dp[j][j] = 1;
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] += 1 + dp[i + 1][j - 1];
            }
        }
        return dp[0][len - 1];
    }
}

