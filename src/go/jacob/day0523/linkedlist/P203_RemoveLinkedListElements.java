package go.jacob.day0523.linkedlist;

import go.jacob.day0520.��������.LinkedListOperate;
import go.jacob.day0520.��������.ListNode;

import static go.jacob.day0520.��������.LinkedListOperate.createLinkedList;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * Credits:
 * Special thanks to @mithmatt for adding this problem and creating all test cases.
 * <p>
 * <p>
 * ˼·���������⾭����Ҫ�Լ�����һ���µ�ͷ��㣬��Ϊԭ�����ͷ�����ܻᱻɾ��
 */
public class P203_RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1, 2, 6, 3, 4, 5, 6}, 7);
        ListNode node = removeElements(head, 6);
        LinkedListOperate.printLinkedList(node);
    }
}
