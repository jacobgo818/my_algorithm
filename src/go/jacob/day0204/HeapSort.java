package go.jacob.day0204;

public class HeapSort {
	public static int[] pq;
	public static int N;

	/*
	 * Ԫ�ش�����β�����루�����������һ���ڵ㣩��Ȼ��ʹ��swim()���� 
	 * ������ͷɾ����Ȼ�����һ��Ԫ�طŵ��±�1��λ�ã�0��λ�ò�ʹ�ã�
	 * Ȼ��ʹ��sink()����
	 */

	private void sink(int k) {
		while (k * 2 <= N) {
			int j = 2 * k;
			if (j < N && pq[j] < pq[j + 1])
				j++;
			if (pq[k] >= pq[j])
				break;
			exch(k, j);
			k = j;
		}
	}

	private void swim(int k) {
		while (k > 1 && pq[k / 2] < pq[k]) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void exch(int i, int j) {
		int key = pq[i];
		pq[i] = pq[j];
		pq[j] = key;
	}
}
