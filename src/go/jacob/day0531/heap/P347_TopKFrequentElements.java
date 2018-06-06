package go.jacob.day0531.heap;

import javax.jnlp.IntegrationService;
import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * You may assume k is always valid, 1 �� k �� number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * <p>
 * �ⷨ��
 * ά��һ������k��Ԫ�ص����ȶ��С������������Ԫ�رȶ����е�
 * ��СƵ��Ԫ�ص�Ƶ�ʸߣ���ȥ����������СƵ�ʵ�Ԫ�أ�����Ԫ����ӡ�
 * ���գ�������ʣ�µģ�����ǰk������Ƶ����ߵ�Ԫ�ء�
 * <p>
 * ��������Ľⷨʹ�����ȶ��У�ʹʱ�临�ӶȽ�����o(nlogk)
 */

public class P347_TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        List<Integer> res = topKFrequent(nums, 2);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i]) + 1);
        }

        Queue<Pair> queue = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.probability - p2.probability;
            }
        });
        for (Integer key : map.keySet()) {

            if (queue.size() == k) {
                if (queue.peek().probability < map.get(key)) {
                    queue.poll();
                    queue.add(new Pair(key, map.get(key)));
                }
            } else {
                queue.add(new Pair(key, map.get(key)));
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (!queue.isEmpty())
            res.add(0, queue.poll().val);

        return res;
    }

    static class Pair {
        public int val;
        public int probability;

        public Pair(int val, int probability) {
            this.val = val;
            this.probability = probability;
        }
    }
}
