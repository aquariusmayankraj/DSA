/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode reverse(ListNode head, int k){
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        int count = 0;
        while(current!=null && count<k){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }
        return previous;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)return null;
        int count = 0;
        ListNode current = head;
        while(current!=null && count<k){
            count++;
            current = current.next;
        }
        if(count==k){
        ListNode newHead = reverse(head,k);
        head.next = reverseKGroup(current,k);
        return newHead;
        }
        return head;
    }
}