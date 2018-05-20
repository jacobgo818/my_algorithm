package go.jacob.day0520.��������;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 �� m �� n �� length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * <p>
 * <p>
 * �ⷨ�������92�⿼�ǵ�����Ҫ��
 * 1�������һ���ڵ�ͷ�ת����ͷ���ǰ�ٽ���һ���µ�ͷ��㣬�Կ��Խ���ͨ�÷�����
 * <p>
 * 5.20 7 ����
 */
public class P92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        int count = 1;
        ListNode cur = newHead;
        while (cur != null && count < m) {
            cur = cur.next;
            count++;
        }
        cur.next = reverse(cur.next, n - m + 1);

        return newHead.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode pre = null, cur = head;
        for (int i = 0; i < k; i++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = cur;
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
