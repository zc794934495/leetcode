class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode a = d;
        ListNode b = d;
        for(int i = 0;i < n + 1;i++){
            a = a.next;
        }
        while(a != null){
            a = a.next;
            b = b.next;
        }
        b.next = b.next.next;
        return d.next;
    }
}