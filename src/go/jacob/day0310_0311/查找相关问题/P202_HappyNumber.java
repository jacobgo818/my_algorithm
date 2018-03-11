package go.jacob.day0310_0311.�����������;


import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * <p>
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * Credits:
 * Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.
 */
public class P202_HappyNumber {

    /*
    �������һ���ѵ���ǣ�����ж���һ����ѭ��
    ����������һ��set���洢�������������дӷ�Ԫ�أ�֤����������ѭ�����˳�����false
     */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();

        int curSum, tmp;
        while (set.add(n)) {
            curSum = 0;
            while (n > 0) {
                tmp = n % 10;
                curSum += tmp * tmp;
                n = n / 10;
            }

            if (curSum == 1)
                return true;
            else
                n = curSum;

        }


        return false;
    }
}
