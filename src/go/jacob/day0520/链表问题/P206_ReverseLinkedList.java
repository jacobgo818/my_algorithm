package go.jacob.day0520.链表问题;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * <p>
 * <p>
 * 解法一：很容易想到用一个栈来遍历一次链表，然后再弹出栈中的节点
 * 最后返回头结点。面试中这种解法不推荐
 * <p>
 * 解法二：遍历一次链表，每个节点都进行next指针修改操作
 * 三个指针pre、cur、next
 * 注意：在链表中要访问next指针，就必须判断当前节点不能为null
 */
public class P206_ReverseLinkedList {


    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null)
                next = next.next;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}


