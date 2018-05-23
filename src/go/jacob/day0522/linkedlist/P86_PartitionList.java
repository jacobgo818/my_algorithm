package go.jacob.day0522.linkedlist;

import go.jacob.day0520.链表问题.LinkedListOperate;
import go.jacob.day0520.链表问题.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * 思路：遍历一次链表，分别处理小于x和大等于x的节点
 */
public class P86_PartitionList {

    public static void main(String[] args) {
        ListNode head = LinkedListOperate.createLinkedList(new int[]{1, 4, 3, 2, 5, 2}, 6);
        ListNode node = partition(head, 3);
        LinkedListOperate.printLinkedList(node);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode less = dump, greaterFirst = null, greater = null, cur = head, next = dump;
        while (cur != null) {
            if (cur.val < x) {
                next = cur.next;
                less.next = cur;
                less = cur;
                if (greaterFirst != null) {
                    less.next = greaterFirst;
                    greater.next = next;
                }
            } else {
                next = cur.next;
                if (greaterFirst == null)
                    greaterFirst = cur;
                greater = cur;

            }
            cur = next;
        }

        return dump.next;

    }
}
