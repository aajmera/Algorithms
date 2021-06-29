package leetcode;

public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode currentHead = null, mainHead = null, lastTail = null, currentNode = null, currentTail = null, node = head;

        while(node != null) {
            if(currentHead == null) currentHead = node;
            ListNode clonedNode = new ListNode(node.val);
            if(currentTail == null) currentTail = clonedNode;

            clonedNode.next = currentNode;
            currentNode = clonedNode;

            if(++count % k == 0) {
                if(mainHead == null) mainHead = currentNode;
                else lastTail.next = currentNode;
                lastTail = currentTail;
                currentNode = currentTail = null;
                currentHead = node.next;
            }

            node = node.next;
        }

        if(count % k != 0) lastTail.next = currentHead;

        return mainHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        node = reverseKGroup(new ListNode(), 0);

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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
