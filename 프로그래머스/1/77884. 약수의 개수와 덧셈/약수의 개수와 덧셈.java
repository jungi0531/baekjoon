class Solution {
    public int solution(int left, int right) {
        // 우선 약수의 개수를 구하는 함수를 사용해야겠네
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            if (div(i)) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
    public boolean div(int n) {
        int count = 0;
        
        // 약수의 개수 어케 구함?
        int i = 1;
        while (n >= i) {
            if (n % i == 0) {
                count++;
            }
            i++;
        }
        
        if (count % 2 == 0) return true;
        return false;
    }
}