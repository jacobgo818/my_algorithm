package go.jacob.day0524.linkedlist;

import go.jacob.day0520.链表问题.LinkedListOperate;
import go.jacob.day0520.链表问题.ListNode;

import static go.jacob.day0520.链表问题.LinkedListOperate.createLinkedList;

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
 * 解法：模拟归并排序
 * 遍历节点：1、当前节点值比头结点小，直接放到头结点，改变root指针
 * 2、当前节点比前一节点大，那么位置不变；
 * 3、当前节点位于链表中间的某个位置，从root节点一个节点一个节点开始遍历，直到找到相应的位置
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
                } else {//位于链表中间位置
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
