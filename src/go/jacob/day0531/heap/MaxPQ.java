package go.jacob.day0531.heap;

/**
 * 手写堆
 * <p>
 * 注意点：
 * 1.堆使用的数组大小是N+1，因为pq[0]不使用
 * 2.删除堆中最大元素以后，把pq[N]放到pq[1]，然后对pq[1]执行sink操作
 * 3.添加元素，每次放到pq[++N]的位置，然后进行swim操作
 */
public class MaxPQ {
    private int[] pq;
    private int N;//元素存储在【1,...,N】，pq[0]没有使用

    public MaxPQ(int maxN) {
        pq = new int[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(int v) {
        pq[++N] = v;
        swim(N);
    }

    public int delMax() {
        int max = pq[1];
        exch(1, N--);
        pq[N + 1] = 0;
        sink(1);
        return max;
    }


    private void sink(int k) {
        while (k * 2 <= N) {
            int j = 2 * k;
            if (j < N && pq[j] < pq[j + 1])
                j = j + 1;
            if (pq[k] >= pq[j])
                break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1) {
            int j = k / 2;
            if (pq[k] <= pq[j])
                break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int k, int j) {
        int tmp = pq[k];
        pq[k] = pq[j];
        pq[j] = tmp;
    }
}
