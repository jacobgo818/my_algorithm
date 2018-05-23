package go.jacob.day0523.linkedlist;


import go.jacob.day0520.链表问题.ListNode;

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
 * 思路：1.当前是重复节点，一直循环，直到节点为空或者找到与当前节点值不一样的节点
 * 2.不是重复节点，修改pre和cur指针
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
