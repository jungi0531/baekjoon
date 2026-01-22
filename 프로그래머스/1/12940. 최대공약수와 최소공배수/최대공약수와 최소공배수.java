class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
        }
        // 최대공약수 구하기
        for (int i = 1; i <= n && i < m; i++) {
            if (n % i == 0 && m % i == 0) answer[0] = i;
        }
        // 최소공배수
        answer[1] = n * m / answer[0];
        
        return answer;
    }
}