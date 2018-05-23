package go.jacob.day0522.linkedlist;


import go.jacob.day0520.链表问题.LinkedListOperate;
import go.jacob.day0520.链表问题.ListNode;

import static go.jacob.day0520.链表问题.LinkedListOperate.createLinkedList;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * <p>
 * Credits:
 * Special thanks to @DjangoUnchained for adding this problem and creating all test cases.
 *
 *
 * 思路：遍历一次链表，根据奇偶分别进行链表操作
 */
public class P328_OddEvenLinkedList {


    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head, evenHead = head.next, even = evenHead;
        ListNode node = even.next;
        boolean isOdd = true;
        while (true) {
            if (isOdd && node != null) {
                odd.next = node;
                odd = odd.next;
            } else {
                even.next = node;
                even = even.next;
            }
            if (node == null)
                break;
            node = node.next;
            isOdd = !isOdd;
        }
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 8);
        ListNode node = oddEvenList(head);
        LinkedListOperate.printLinkedList(node);
    }
}
