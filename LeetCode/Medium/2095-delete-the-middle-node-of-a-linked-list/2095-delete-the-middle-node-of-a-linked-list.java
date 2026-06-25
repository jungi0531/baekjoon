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
    public ListNode deleteMiddle(ListNode head) {
        // 일단 총 개수를 먼저 세고 그 수의 반만큼 가서 지우기
        int count = 0;

        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        cur = head;
        ListNode prev = null;

        for (int i = 0; i < count / 2; i++) {
            prev = cur;
            cur = prev.next;
        }
        if (prev == null) return null;
        
        prev.next = cur.next;

        return head;
    }
}