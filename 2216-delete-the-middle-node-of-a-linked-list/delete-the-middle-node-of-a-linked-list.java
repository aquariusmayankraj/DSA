class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null||head.next==null)return null;
        ListNode current = head ;
        int count = 0;
        while(current!=null){
            count++;
            current = current.next;
        }
        current =head;
        int mid = count/2;
        for(int i=1;i<mid;i++){
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}