class Solution {
    public int solution(int n, int k) {
        // n을 k진수로 전환...
        // 0이 나올 때까지 간 다음 그 중간의 숫자가 소수이면 ++
        int answer = 0;
        
        String number = convert(n, k);
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0') {
                int ii = i;
                while (ii < number.length() && number.charAt(ii) != '0') {
                    ii++;
                }
                long temp = Long.parseLong(number.substring(i, ii));
                if (isPrime(temp)) {
                    answer++;
                }
                i = ii;
            }
        }
        
        return answer;
    }
    public String convert(int n, int k) {
        StringBuilder sb = new StringBuilder("");
        
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
    public boolean isPrime(long n) {
        if (n < 2) return false;
        
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}