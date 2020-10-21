import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        if(A == null) {
            return false;
        }
        ListNode mid = findMiddleNode(A);
        ListNode rev = reverse(mid);
        while(rev != null) {
            if(rev.val != A.val) {
                return false;
            }
            rev = rev.next;
            A = A.next;
        }
        return true;
    }
    public ListNode findMiddleNode(ListNode A) {
        ListNode fast = A;
        ListNode slow = A;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode A) {
        ListNode cur = A;
        ListNode pre = null;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}