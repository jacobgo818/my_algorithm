package go.jacob.day0520.Á´±íÎÊÌâ;

public class LinkedListOperate {
    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        printLinkedList(head);
    }


    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
              head = head.next;
            if (head != null)
                System.out.print("-->");
        }
    }

    public static ListNode createLinkedList(int[] arr, int n) {
        if (n == 0)
            return null;
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return head.next;
    }

}
