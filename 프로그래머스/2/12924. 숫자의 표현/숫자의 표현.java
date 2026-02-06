class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i += 2) { // 홀수만 확인
            if (n % i == 0) answer++;
        }
        return answer;
    }
}