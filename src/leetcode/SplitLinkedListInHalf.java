package leetcode;

public class SplitLinkedListInHalf {

    public static ListNode[] splitListToParts(ListNode head, int k) {
        //calculate the size of linked list
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }

        //elements per block = size/k
        int elementsPerBlock = count/k;
        int remainder = count%k;

        ListNode[] result = new ListNode[k];
        temp = head;

        for(int i=0; i<k; i++) {
            int currentNodes = elementsPerBlock;
            if(remainder != 0) {
                currentNodes++;
                remainder--;
            }
            if(currentNodes > 0) {
                for(int j=1; j<currentNodes; j++) temp = temp.next;

                result[i] = head;
                head = temp.next;
                temp.next = null;
                temp = head;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode[] nodes = splitListToParts(node, 6);

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return String.format("current - %d", val);
        }
    }
}
