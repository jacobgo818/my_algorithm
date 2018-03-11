package go.jacob.day0204.sort;

public class Merge {
	public static int[] aux;

	/**
	 * 排序入口
	 * 
	 * @param a
	 */
	public static void sort(int[] a) {
		aux = new int[a.length];
		sort(a, 0, a.length - 1);
	}

	public static void sort(int[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	/**
	 * 合并两个数组
	 * 
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(int[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (aux[i] > aux[j])
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
}
