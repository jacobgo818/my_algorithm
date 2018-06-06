package go.jacob.day0524.linkedlist;

import go.jacob.day0520.��������.LinkedListOperate;
import go.jacob.day0520.��������.ListNode;

import static go.jacob.day0520.��������.LinkedListOperate.createLinkedList;

/**
 * Sort a linked list using insertion sort.
 * <p>
 * <p>
 * A graphical example of insertion sort.
 * The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 * <p>
 * <p>
 * Algorithm of Insertion Sort:
 * <p>
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * <p>
 * �ⷨ��ģ��鲢����
 * �����ڵ㣺1����ǰ�ڵ�ֵ��ͷ���С��ֱ�ӷŵ�ͷ��㣬�ı�rootָ��
 * 2����ǰ�ڵ��ǰһ�ڵ����ôλ�ò��䣻
 * 3����ǰ�ڵ�λ�������м��ĳ��λ�ã���root�ڵ�һ���ڵ�һ���ڵ㿪ʼ������ֱ���ҵ���Ӧ��λ��
 */

public class P147_InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode root = head;
        ListNode cur = head.next;
        ListNode beforeCur = head;

        while (cur != null) {
            if (cur.val >= beforeCur.val) {
                beforeCur = cur;
                cur = cur.next;
            } else {
                if (cur.val <= root.val) {
                    beforeCur.next = cur.next;
                    cur.next = root;
                    root = cur;
                    cur = beforeCur.next;
                } else {//λ�������м�λ��
                    ListNode searchNode = root;
                    while (searchNode.next.val <= cur.val) {
                        searchNode = searchNode.next;
                    }
                    beforeCur.next = cur.next;
                    cur.next = searchNode.next;
                    searchNode.next = cur;
                    cur = beforeCur.next;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{4, 2, 1, 3}, 4);
        ListNode node = insertionSortList(head);
        LinkedListOperate.printLinkedList(node);
    }
}
