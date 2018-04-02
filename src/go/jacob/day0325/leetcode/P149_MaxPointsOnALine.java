package go.jacob.day0325.leetcode;

import java.util.HashMap;

/**
 * 给定二维平面上有 n 个点，求最多有多少点在同一条直线上。
 */
public class P149_MaxPointsOnALine {

    /*
    遍历每个点，看它和后面的每个点构成的直线上有多少个点
    对每个点建立map，斜率是key
    斜率要用分数的形式，不要用double的形式存
    计算分数时先求分子分母的最大公约数gcd，再都除以gcd
    重合的点特殊处理
     */
    public int maxPoints(Point[] points) {
        if (points.length <= 2)
            return points.length;

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int overLap = 0;//重叠
            int lineMax = 0;//当前循环在一条直线上的最多点数
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    overLap++;
                    continue;
                }

                int gcd = generateGcd(x, y);
                x /= gcd;
                y /= gcd;
                String slope = String.valueOf(x) + String.valueOf(y);
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else
                    map.put(slope, 1);
                lineMax = Math.max(lineMax, map.get(slope));
            }
            res = Math.max(res, lineMax + overLap + 1);

        }


        return res;
    }

    /*
    辗转相除：获得最大公约数
     */
    private int generateGcd(int x, int y) {
        if (y == 0)
            return x;
        return generateGcd(y, x % y);
    }


    private static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
