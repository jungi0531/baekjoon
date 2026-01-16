class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 1과 자신 외에 나누어지는 숫자가 있으면 합성 수
        for (int i = 1; i <= n; i++) {
            for (int ii = 2; ii < i; ii++) {
                if (i % ii == 0) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}