package go.jacob.day0323.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        ArrayList<Long> list = new ArrayList<Long>();
        String s;
        for (int i = 0; i < n; i++) {
            s = sc.nextLine();
            Long res = getRes(s);
            list.add(res);
        }
        System.out.println(list.get(0));

        printRes(list);
    }

    private static Long getRes(String s) {
        long cur = 0l;
        long sum = 0l;
        long symbol = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigital(c)) {
                cur = cur * 10 + c - '0';
            } else if (c == '+') {
                sum += symbol * cur;
                cur = 0;
                symbol = 1;
            } else if (c == '-') {
                sum += symbol * cur;
                cur = 0;
                symbol = -1;

            } else {
                symbol *= cur;
                cur = 0;
            }
        }
        return sum + cur * symbol;

    }


    private static boolean isDigital(char c) {
        if (c == '+' || c == '-' || c == '*')
            return false;
        return true;

    }


    public static void printRes(List<Long> list) {
        String[][] charNum = {{"66666", "....6", "66666", "66666", "6...6", "66666", "66666", "66666", "66666", "66666"},
                              {"6...6", "....6", "....6", "....6", "6...6", "6....", "6....", "....6", "6...6", "6...6"},
                              {"6...6", "....6", "66666", "66666", "66666", "66666", "66666", "....6", "66666", "66666"},
                              {"6...6", "....6", "6....", "....6", "....6", "....6", "6...6", "....6", "6...6", "....6"},
                              {"66666", "....6", "66666", "66666", "....6", "66666", "66666", "....6", "66666", "66666"}};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < list.size(); j++) {
                String num = list.get(j) + "";
                for (int k = 0; k < num.length(); k++) {
                    int index = num.charAt(k) - '0';
                    System.out.print(charNum[i][index]);
                    if (j == list.size() - 1 && k == num.length() - 1)
                        continue;
                    System.out.print("..");
                }
            }
            System.out.println();
        }
    }
}
