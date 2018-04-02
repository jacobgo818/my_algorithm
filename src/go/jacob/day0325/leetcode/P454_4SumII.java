package go.jacob.day0325.leetcode;


import java.util.Arrays;
import java.util.HashMap;

/**
 * Given four lists A, B, C, D of integer values,
 * compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

 To make problem a bit easier, all A, B, C, D have same length of N where 0 �� N �� 500.
 All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

 Example:

 Input:
 A = [ 1, 2]
 B = [-2,-1]
 C = [-1, 2]
 D = [ 0, 2]

 Output:
 2

 Explanation:
 The two tuples are:
 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class P454_4SumII {
    /*
    ��ĿѰ�Ҳ�ͬ��ijkl��ϣ����Լ�ʹ�������ͬ���֣�Ҳ������������
    �����ⷨO(n^4),����ת��ΪO(N^2);
    ʱ�临�Ӷ�O��n2��
    �ռ临�Ӷ�O��n2��
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//��Ϊ��ͬ�������Ͽ��ܴ��ڶ��
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                if(map.containsKey(C[i]+D[j]))
                    map.put(C[i]+D[j],map.get(C[i]+D[j])+1);
                else
                    map.put(C[i]+D[j],1);
            }
        }

        Arrays.sort(A);
        Arrays.sort(B);
        int target=0;
        int count=0;

        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                target=0-A[i]-B[j];
                if(map.containsKey(target)){
                    count+=map.get(target);
                }
            }
        }

        return count;
    }
}
