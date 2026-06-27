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
    public ListNode oddEvenList(ListNode head) {
        // 짝수번째 있는 노드를 맨 뒤로 그대로 옮겨라..
        // 첫 번째 짝수 노드 위치 기억해놓고 다 바로 다음 거 가리키다가 홀수 번째 마지막 노드랑 합치기
        if (head == null || head.next == null) return head;

        int count = 1;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;

        ListNode firstEven = next;

        while (cur != null && next != null) {
            count++;
            prev = cur;
            cur.next = next.next;
            cur = next;
            next = next.next;
        }

        System.out.println(count);
        if (count % 2 == 0) {
            prev.next = firstEven;
        } else {
            cur.next = firstEven;
        }

        return head;
    }
}