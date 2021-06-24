package leetcode;

public class ReverseLinkedList2 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right ||
                head.next == null) return head;

        ListNode leftFixed = null, rightFixed = null, leftReversed = null, rightReversed = null;
        ListNode currentNode = head;
        int count = 0;

        while(count <= right + 1 && currentNode != null) {
            count++;

            if(count == left - 1) leftFixed = currentNode;
            else if (count == right + 1) rightFixed = currentNode;
            else if (count >= left && count <= right) {
                ListNode node = new ListNode(currentNode.val);
                if(rightReversed == null) rightReversed = node;

                if(leftReversed == null) leftReversed = node;
                else {
                    node.next = leftReversed;
                    leftReversed = node;
                }
            }

            currentNode = currentNode.next;
        }

        if(leftFixed != null) leftFixed.next = leftReversed;
        else head = leftReversed;

        rightReversed.next = rightFixed;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode node = reverseBetween(head, 1, 5);
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
