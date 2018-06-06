package go.jacob.day0530.queue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class P279_PerfectSquares {

    /*
    解法二：
    为了出现冗余推入的queue的情况，在解法一基础上
    另外使用一个数组来记录某一数字是否入队
     */
    public int numSquares(int n) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(n, 0));
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            int num = queue.peek().num;
            int step = queue.peek().step;
            queue.poll();

            for (int i = 1; num - i * i >= 0; i++) {
                int a = num - i * i;
                if (a < 0)
                    break;
                if (a == 0)
                    return step + 1;
                if (visited[a])
                    continue;
                queue.offer(new Pair(a, step + 1));
                visited[a] = true;
            }
        }
        throw new RuntimeException("no solution");

    }

    /*
    解法一：
    使用图BES来解决问题，当n较小的时候，可以解决问题
    当n过大时，超时

    原因：queue中会推入很多冗余的节点
     */
    public int numSquares_1(int n) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(n, 0));

        while (!queue.isEmpty()) {
            int num = queue.peek().num;
            int step = queue.peek().step;
            queue.poll();

            if (num == 0) {
                return step;
            }

            for (int i = 1; num - i * i >= 0; i++) {
                queue.offer(new Pair(num - i * i, step + 1));
            }
        }
        throw new RuntimeException("no solution");

    }

    class Pair {
        public int num;
        public int step;

        public Pair(int num, int step) {
            this.num = num;
            this.step = step;
        }
    }


}
