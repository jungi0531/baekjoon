class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (answer % 3 == 0) {
                // 3의 배수라면
                answer++;
                i--;
            } else if (String.valueOf(answer).contains("3")){
                // 3이 포함된 숫자
                answer++;
                i--;
            } else {
                answer++;
            }
        }
        return answer - 1;
    }
}