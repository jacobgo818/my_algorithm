package go.jacob.day0325.leetcode;


import org.junit.Test;

import java.util.HashMap;

/**
 * Given n points in the plane that are all pairwise distinct,
 * a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j
 * equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs.
 * You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class P447_NumberOfBoomerangs {
    @Test
    public void test() {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        int res = numberOfBoomerangs(points);
        System.out.println(res);
    }


    /*
    细节：由于两个点间的距离有可能是小数，会影响计算结果，采用不开方的值为键
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (map.containsKey(dist(points[i], points[j])))
                        map.put(dist(points[i], points[j]), map.get(dist(points[i], points[j])) + 1);
                    else
                        map.put(dist(points[i], points[j]), 1);
                }
            }
            for (Integer count : map.values()) {
                res += count * (count - 1);
            }
        }

        return res;

    }

    private Integer dist(int[] point, int[] point1) {
        return (point[0] - point1[0]) * (point[0] - point1[0]) + (point[1] - point1[1]) * (point[1] - point1[1]);
    }
}
