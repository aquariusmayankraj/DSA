class Solution {

    public void swap(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public ListNode swapNodes(ListNode head, int k) {

        ListNode first = head;

        for(int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode kthFromStart = first;

        ListNode second = head;

        while(first.next != null) {
            first = first.next;
            second = second.next;
        }

        swap(kthFromStart, second);

        return head;
    }
}
