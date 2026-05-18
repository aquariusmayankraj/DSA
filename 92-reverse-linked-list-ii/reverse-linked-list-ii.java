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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        for(int i=0;i<left-1;i++){
            p1 = p1.next;
        }
        ListNode subListHead = p1.next;
        ListNode p2=subListHead;
        for(int i=0;i<right-left;i++){
            p2=p2.next;
        }
        ListNode rest = p2.next;
        p2.next=null;
        ListNode reverseSubListHead = reverse(subListHead);
        p1.next = reverseSubListHead;
        subListHead.next = rest;
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}