class Solution {
    public long solution(int n) {
        // 1칸 점프 혹은 2칸 점프로 n까지 가는 경우의 수 -> dp?
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1234567;
        }
        
        return dp[n];
    }
}