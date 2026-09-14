class Solution {
    public int solution(int n) {
        int[] fibo = new int[100_001];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= 100_000; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            fibo[i] %= 1234567;
        }
        
        return fibo[n];
    }
}