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
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode node1 = head;
        ListNode node2 = mid;
        node2 = reverseList(node2);
        mergeList(node1,node2);
    }
    //找链表中间节点
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //翻转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    //合并两个链表
    public void mergeList(ListNode node1, ListNode node2) {
        ListNode node1Tmp;
        ListNode node2Tmp;
        while(node1 != null && node2 != null) {
            node1Tmp = node1.next;
            node2Tmp = node2.next;
            node1.next = node2;
            node1 = node1Tmp;
            node2.next = node1;
            node2 = node2Tmp;
        }
    }
}