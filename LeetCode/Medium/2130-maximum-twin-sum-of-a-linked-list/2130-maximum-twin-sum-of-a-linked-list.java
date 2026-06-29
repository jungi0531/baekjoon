import java.util.*;

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
    public int pairSum(ListNode head) {
        // 우선 n 구하고 n / 2만큼 스택에 넣어놓고 빼면서 가장 큰 값 저장하면 되는 거 아님?
        if (head == null) return 0;

        Stack<Integer> stack = new Stack<>();

        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        int max = 0;

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }

        for (int i = 0; i < count; i++) {
            max = Math.max(max, stack.pop() + slow.val);
            slow = slow.next;
        }

        return max;
    }
}