package leetcode;

public class MergeSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode currentNode = null;

        int countOfNodes = lists.length;

        while (countOfNodes > 0) {
            int min = Integer.MAX_VALUE;
            int minNodeIndex = -1;
            for(int i=0; i<lists.length; i++) {
                ListNode node = lists[i];
                if (node != null && node.val <= min) {
                    min = node.val;
                    minNodeIndex = i;
                }
            }

            if(minNodeIndex == -1) return head;

            if(head == null) head = currentNode = lists[minNodeIndex];
            else currentNode.next = currentNode = lists[minNodeIndex];

            if(lists[minNodeIndex].next == null) countOfNodes--;
            lists[minNodeIndex] = lists[minNodeIndex].next;
        }

        return head;
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode ln = new ListNode();

        ListNode[] nodes = {head1, head2, head3};

        ListNode node = mergeKLists(nodes);
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
            return String.valueOf(val);
        }
    }
}
