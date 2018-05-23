package go.jacob.day0523.linkedlist;


import go.jacob.day0520.��������.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 * <p>
 * ˼·��1.��ǰ���ظ��ڵ㣬һֱѭ����ֱ���ڵ�Ϊ�ջ����ҵ��뵱ǰ�ڵ�ֵ��һ���Ľڵ�
 * 2.�����ظ��ڵ㣬�޸�pre��curָ��
 */
public class P82_RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        boolean isDuplicate;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            isDuplicate = false;
            ListNode tmp = cur;
            while (tmp.next != null && tmp.next.val == tmp.val) {
                isDuplicate = true;
                tmp = tmp.next;
            }

            if (isDuplicate) {
                pre.next = tmp.next;
                cur = tmp.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
