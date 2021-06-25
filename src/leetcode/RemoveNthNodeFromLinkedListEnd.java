package leetcode;

public class RemoveNthNodeFromLinkedListEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempListHead = head;
        ListNode node = head;

        int count = 0;

        while(node != null) {
            if (++count > n+1) tempListHead = tempListHead.next;
            node = node.next;
        }

        if(count == n) return head.next;

        tempListHead.next = tempListHead.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode node = removeNthFromEnd(head, 1);
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
