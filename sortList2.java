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
    //快排链表
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 添加头节点，最后返回时去掉即可。
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        return quickSort(newHead, null);
    }

    // 带头结点的链表快速排序
    private ListNode quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end || head.next.next == end) {
            return head;
        }
        ListNode tmpHead = new ListNode(-1);
        // partition为划分点，p为链表指针，tp为临时链表指针
        ListNode partition = head.next;
        ListNode p = partition;
        ListNode tp = tmpHead;
        // 将小于划分点的结点放到临时链表中
        while (p.next != end) {
            if (p.next.val < partition.val) {
                tp.next = p.next;
                tp = tp.next;
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        // 合并临时链表和原链表，将原链表接到临时链表后面即可
        tp.next = head.next;
        // 将合并后的链表插回原链表
        head.next = tmpHead.next;
        quickSort(head, partition);
        quickSort(partition, end);
        return head.next;
    }
}