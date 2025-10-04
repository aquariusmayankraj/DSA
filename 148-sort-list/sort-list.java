import java.util.*;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        // Step 1: Copy values to a list
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while(current != null){
            list.add(current.val);
            current = current.next;
        }

        // Step 2: Sort the list
        Collections.sort(list);

        // Step 3: Put sorted values back into the linked list
        current = head;
        for(int i = 0; i < list.size(); i++){
            current.val = list.get(i);
            current = current.next;
        }

        return head;
    }
}
