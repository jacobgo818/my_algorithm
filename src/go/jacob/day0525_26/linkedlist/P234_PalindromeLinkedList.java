package go.jacob.day0525_26.linkedlist;

import go.jacob.day0520.链表问题.ListNode;

import static go.jacob.day0520.链表问题.LinkedListOperate.createLinkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 *
 * 思路：
 * 将链表从中间截断（节点奇数和偶数的情况）
 * 然后将后半链表进行reverse操作
 * 最后再对节点的值进行比较，返回结果
 */
public class P234_PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow.next);
        slow.next = null;

        while (head2 != null) {
            if (head2.val != head.val)
                return false;
            head = head.next;
            head2 = head2.next;
        }


        return true;
    }

    private static ListNode reverse(ListNode node) {
        if (node == null || node.next == null)
            return node;
        ListNode cur = null, next = node;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        return cur;
    }


    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1, 2, 3,3, 2, 1}, 6);
//        ListNode head = createLinkedList(new int[]{1, 2}, 2);
        System.out.println(isPalindrome(head));

    }
}
