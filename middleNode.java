/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode secend = head;
        while(first != null&& first.next != null){
            first = first.next.next;
            secend = secend.next;
        }
        return secend;
    }
}