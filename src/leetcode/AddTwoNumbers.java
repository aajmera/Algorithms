package leetcode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int carry = 0;
        if(sum > 9) {
            carry = sum/10;
            sum%=10;
        }
        ListNode begin = new ListNode(sum);
        ListNode node = begin;

        while(l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;

            sum = carry + l1.val + l2.val;
            carry = 0;
            if(sum > 9) {
                carry = sum/10;
                sum%=10;
            }

            ListNode next = new ListNode(sum);
            node.next = next;
            node = next;
        }

        while(l1.next != null) {
            if(carry == 0) {
                node.next = l1.next;
                break;
            }
            l1 = l1.next;
            sum = carry + l1.val;
            carry = 0;
            if(sum > 9) {
                carry = sum/10;
                sum%=10;
            }
            ListNode next = new ListNode(sum);
            node.next = next;
            node = next;
        }

        while(l2.next != null) {
            if(carry == 0) {
                node.next = l2.next;
                break;
            }
            l2 = l2.next;
            sum = carry + l2.val;
            carry = 0;
            if(sum > 9) {
                carry = sum/10;
                sum%=10;
            }
            ListNode next = new ListNode(sum);
            node.next = next;
            node = next;
        }

        if(carry > 0) {
            node.next = new ListNode(carry);
        }

        return begin;
    }

    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
