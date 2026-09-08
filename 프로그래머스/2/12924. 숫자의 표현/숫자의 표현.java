class Solution {
    public int solution(int n) {
        // n을 연속된 자연 수의 합으로 표현하는 방법
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int ii = i; ii <= n; ii++) {
                sum += ii;
                if (sum == n) answer++;
                if (sum >= n) break;
            }
        }
        
        return answer;
    }
}