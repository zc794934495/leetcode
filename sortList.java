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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    // 归并排序
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slowp = head;
        ListNode fastp = head.next.next;
        ListNode l;
        ListNode r;
        // 快慢指针找出中位点
        while (fastp != null && fastp.next != null) {
            slowp = slowp.next;
            fastp = fastp.next.next;
        }
        // 对右半部分进行归并排序
        r = mergeSort(slowp.next);
        // 链表判断结束的标志：末尾节点.next==null
        slowp.next = null;
        // 对左半部分进行归并排序
        l = mergeSort(head);
        return mergeList(l, r);
    }

    // 合并链表
    private ListNode mergeList(ListNode l, ListNode r) {
        ListNode tmpHead = new ListNode(-1);
        ListNode temp = tmpHead;
        while (l != null && r != null) {
            if (l.val < r.val) {
                temp.next = l;
                l = l.next;
            } else {
                temp.next = r;
                r = r.next;
            }
            temp = temp.next;
        }
        temp.next = l == null ? r : l;
        return tmpHead.next;
    }
}