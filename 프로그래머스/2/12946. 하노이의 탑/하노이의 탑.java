class Solution {
    static int[][] answer;
    static int count;

    public int[][] solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 2 * dp[i - 1] + 1;
        }
        answer = new int[dp[n]][2];
        count = 0;
        // 하노이 타블 하르믄 우선 함수를 만들고 그 안에서.. n을 매개변수로 재귀..
        hanoi(n, 1, 3, 2);
        
        return answer;
    }
    public void hanoi(int n, int from, int to, int mid) {
        if (n <= 1) {
            answer[count][0] = from;
            answer[count][1] = to;
            count++;
            return;
        }
        hanoi(n - 1, from, mid, to);
        hanoi(1, from, to, mid);
        hanoi(n - 1, mid, to, from);
    }
}