/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode con = pre;//所求链表的头结点
        ListNode tail = cur;//位置 m 到 n 链表反转后的尾结点
        while(n > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        //判断第一个节点是否需要反转
        if (con != null) {
            con.next = pre;
        } else {
            head = pre;
        }
        tail.next = cur;
        return head;
    }
}