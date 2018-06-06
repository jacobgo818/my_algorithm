package go.jacob.day0525_26.linkedlist;

import go.jacob.day0520.链表问题.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 * <p>
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 * <p>
 * 题意：给定链表中的一个节点，删除该节点
 * <p>
 * 思路：因为无法拿到当前节点的前一节点，所以只能通过value赋值来求解
 */
public class P237_DeleteNodeInaLinkedList {

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null)
            return;
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
