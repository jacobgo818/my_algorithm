package go.jacob.day0325.leetcode;

import java.util.HashMap;

/**
 * ������άƽ������ n ���㣬������ж��ٵ���ͬһ��ֱ���ϡ�
 */
public class P149_MaxPointsOnALine {

    /*
    ����ÿ���㣬�����ͺ����ÿ���㹹�ɵ�ֱ�����ж��ٸ���
    ��ÿ���㽨��map��б����key
    б��Ҫ�÷�������ʽ����Ҫ��double����ʽ��
    �������ʱ������ӷ�ĸ�����Լ��gcd���ٶ�����gcd
    �غϵĵ����⴦��
     */
    public int maxPoints(Point[] points) {
        if (points.length <= 2)
            return points.length;

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int overLap = 0;//�ص�
            int lineMax = 0;//��ǰѭ����һ��ֱ���ϵ�������
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
    շת�����������Լ��
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
