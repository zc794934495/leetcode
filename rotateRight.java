/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }
        int size = 1;
        int n;
        ListNode tmp = head;
        while(tmp.next != null) {
            tmp = tmp.next;
            size++;
        }
        tmp.next = head;
        for(int i = 0;i < (size - (k % size) - 1);i++) {
            head = head.next;
        }
        tmp = head;
        head = head.next;
        tmp.next = null;
        return head;
    }
}