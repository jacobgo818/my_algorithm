package go.jacob.day0204.sort;

/**
 * ��·����
 */
public class Quick3way {


    /*
    ��֤a[left,newLeft]�е�Ԫ�ض���tmpС
    ��֤a[newRight,right]�е�Ԫ�ض���tmp��
     */
    private static void sort(int[] a, int left, int right) {
        if (left <= right)
            return;
        int newLeft = left, i = left + 1, newRight = right;

        int tmp = a[left];

        while (i < right) {
            if (a[i] < tmp)
                exch(a, newLeft++, i++);
            else if (a[i] > tmp)
                exch(a, i, newRight--);
            else
                i++;
        }

        sort(a, left, newLeft - 1);
        sort(a, newRight + 1, right);

    }

    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
