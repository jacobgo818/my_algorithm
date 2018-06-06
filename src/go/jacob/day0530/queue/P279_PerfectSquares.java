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
    �ⷨ����
    Ϊ�˳������������queue��������ڽⷨһ������
    ����ʹ��һ����������¼ĳһ�����Ƿ����
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
    �ⷨһ��
    ʹ��ͼBES��������⣬��n��С��ʱ�򣬿��Խ������
    ��n����ʱ����ʱ

    ԭ��queue�л�����ܶ�����Ľڵ�
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
