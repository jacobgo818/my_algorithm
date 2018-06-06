package go.jacob.day0525_26.linkedlist;

import go.jacob.day0520.链表问题.LinkedListOperate;
import go.jacob.day0520.链表问题.ListNode;

import static go.jacob.day0520.链表问题.LinkedListOperate.createLinkedList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * <p>
 * <p>
 * 解题思路：
 * 首先获取链表中间节点，然后将链表从中间节点切开（注意奇偶数）
 * 然后对第二个链表进行reverse操作
 * 最后，两个链表两两搭配即可
 */
public class P143_ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverse(head2);
        LinkedListOperate.printLinkedList(head);
        System.out.println("\n");
        LinkedListOperate.printLinkedList(head2);

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (head != null) {
            node.next = head;
            head = head.next;
            node = node.next;
            if (head2 != null) {
                node.next = head2;
                head2 = head2.next;
                node = node.next;
            }
        }
        LinkedListOperate.printLinkedList(dummy);

    }

    private static ListNode reverse(ListNode head) {
        ListNode first = null, second = head, newHead = null;
        while (second != null) {
            newHead = second;
            ListNode tmp = second.next;
            second.next = first;
            first = second;
            second = tmp;

        }
        return newHead;

    }

    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4}, 4);
        reorderList(head);

    }
}
