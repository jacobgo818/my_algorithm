package go.jacob.day0525_26.linkedlist;

import go.jacob.day0520.��������.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 * <p>
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 * <p>
 * ���⣺���������е�һ���ڵ㣬ɾ���ýڵ�
 * <p>
 * ˼·����Ϊ�޷��õ���ǰ�ڵ��ǰһ�ڵ㣬����ֻ��ͨ��value��ֵ�����
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
