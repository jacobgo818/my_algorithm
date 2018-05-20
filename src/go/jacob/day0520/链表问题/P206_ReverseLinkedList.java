package go.jacob.day0520.��������;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * <p>
 * <p>
 * �ⷨһ���������뵽��һ��ջ������һ������Ȼ���ٵ���ջ�еĽڵ�
 * ��󷵻�ͷ��㡣���������ֽⷨ���Ƽ�
 * <p>
 * �ⷨ��������һ������ÿ���ڵ㶼����nextָ���޸Ĳ���
 * ����ָ��pre��cur��next
 * ע�⣺��������Ҫ����nextָ�룬�ͱ����жϵ�ǰ�ڵ㲻��Ϊnull
 */
public class P206_ReverseLinkedList {


    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null)
                next = next.next;
        }
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


