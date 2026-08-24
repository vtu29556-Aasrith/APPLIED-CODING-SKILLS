class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;
        
        while (true) {
            ListNode cursor = prevGroup;
            for (int i = 0; i < k; i++) {
                cursor = cursor.next;
                if (cursor == null) {
                    return dummy.next; 
                }
            }
            ListNode groupStart = prevGroup.next;
            ListNode curr = groupStart;
            ListNode next = null;
            ListNode prev = null;
            
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            prevGroup.next = prev;
            groupStart.next = curr;
            prevGroup = groupStart;
        }
    }
}