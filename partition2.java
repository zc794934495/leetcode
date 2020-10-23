/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition2(ListNode head, int x) {
        ListNode heada = new ListNode(-1);
        ListNode headb = new ListNode(-1);
        ListNode tmp = head;
        ListNode tmpa = heada;
        ListNode tmpb = headb;
        while(tmp != null) {
            if(tmp.val >= x) {
                tmpb.next = tmp;
                tmpb = tmpb.next;
            }else {
                tmpa.next = tmp;
                tmpa = tmpa.next;
            }
            tmp = tmp.next;
        }
        tmpb.next = null;
        tmpa.next = headb.next;
        return heada.next;
    }
}