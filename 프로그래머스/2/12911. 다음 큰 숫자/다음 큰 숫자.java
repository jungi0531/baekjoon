class Solution {
    public int solution(int n) {
        // 다음  큰 숫자란: n과 이진 수로 했을 때 1 개수 같은 다음 큰 수
        
        for (int i = n + 1; i < 1_000_000; i++) {
            if (countOne(n) == countOne(i)) return i;
        }
        
        return -1;
    }
    public int countOne(int n) {
        int count = 0;
        
        while (n > 0) {
            if (n % 2 == 1) count++;
            n /= 2;
        }
        
        return count;
    }
}