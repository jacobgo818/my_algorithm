package go.jacob.day0204;

public class Quick {

	public static void sort(int[] a) {
		sort(a, 0, a.length);
	}

	private static void sort(int[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		int tmp = a[lo];

		while (true) {
			while (a[++i] < tmp)
				if (i == hi)
					break;
			while (a[--j] > tmp)
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	private static void exch(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
