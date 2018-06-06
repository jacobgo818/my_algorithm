package go.jacob.day0531.heap;

/**
 * ��д��
 * <p>
 * ע��㣺
 * 1.��ʹ�õ������С��N+1����Ϊpq[0]��ʹ��
 * 2.ɾ���������Ԫ���Ժ󣬰�pq[N]�ŵ�pq[1]��Ȼ���pq[1]ִ��sink����
 * 3.���Ԫ�أ�ÿ�ηŵ�pq[++N]��λ�ã�Ȼ�����swim����
 */
public class MaxPQ {
    private int[] pq;
    private int N;//Ԫ�ش洢�ڡ�1,...,N����pq[0]û��ʹ��

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
