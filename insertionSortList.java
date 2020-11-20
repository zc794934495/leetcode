/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = head; //当前节点的前驱
        ListNode cur = head.next; //当前节点
        ListNode next = cur.next; //记录当前节点后继，在当前节点移动后，next就是下一个插入节点
        while(cur != null) { //如果当前节点不为空
            if(cur.val < prev.val) { //当前节点小于上一个节点，需要移动
                ListNode temp = head; //记录第一个大于当前节点的节点
                ListNode tempPre = null; //记录第一个大于当前节点的节点的前驱
                //从链表头找第一个大于当前节点的节点
                while(temp.val < cur.val) {
                    temp = temp.next;
                    if(tempPre == null) {
                        tempPre = head;
                    }else {
                        tempPre = tempPre.next;
                    }
                }
                //找到了当前节点应该插入的位置
                prev.next = next; 
                //如果tempPre为空说明当前节点需要移动到头结点，改变头结点指向
                if(tempPre != null) {
                    tempPre.next = cur;
                }else {
                    head = cur;
                }
                cur.next = temp;
                cur = next;
            }else { //当前节点大于或等于当前节点，不需要移动
                prev = cur;
                cur = next;
            }
            //当前节点是最后一个节点
            if(next != null) {
                next = next.next;
            }
        }
        return head;
    }
}