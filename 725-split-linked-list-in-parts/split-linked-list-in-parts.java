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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count=0;
        ListNode curr = head;
        while(curr!=null){
            count++;
            curr = curr.next;
        }

        int base_size = count/k;
        int left_Node = count%k;
        ListNode[] result = new ListNode[k];
        curr = head;
        for(int i=0;i<k;i++){
            result[i] = curr;
            int current_size = base_size + (i<left_Node?1:0);
            ListNode prev = null;
            for(int j=0;j<current_size;j++){
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) {
                prev.next = null;
            }
        }
        return result;
    }
}