package go.jacob.day0409.jd;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] strs = new String[t];
        for (int i = 0; i < t; i++)
            strs[i] = sc.next();

        for (int i = 0; i < t; i++) {
            String str = strs[i].trim();
            if (str.length() % 2 == 1) {
                System.out.println("No");
            } else {
                int left = 0, right = 0;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '(') {
                        left++;
                    } else {
                        if (++right - left > 2) {
                            break;
                        }
                    }
                }
                if (left == right)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }

}
