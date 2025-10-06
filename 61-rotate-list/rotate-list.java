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
    public ListNode rotateRight(ListNode head, int k) {
        //edge case
        if(head==null || head.next==null || k==0)return head;

        // length count kar loo
        ListNode current = head;
        int length = 1;
        while(current.next!=null){
            current = current.next;
            length++;
        }

        //circle banaunga
        current.next = head;

        k = k % length;
        int stepsofNewHead = length-k;
        ListNode newTail = head;
        for(int i=1; i<stepsofNewHead;i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}






