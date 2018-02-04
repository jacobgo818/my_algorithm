package go.jacob.day0204;

public class HeapSort {
	public static int[] pq;
	public static int N;

	/*
	 * 元素从数组尾部插入（即二叉树最后一个节点），然后使用swim()方法 
	 * 从数组头删除，然后将最后一个元素放到下标1的位置（0的位置不使用）
	 * 然后使用sink()方法
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
