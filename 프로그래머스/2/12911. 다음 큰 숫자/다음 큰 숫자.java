class Solution {
    public int solution(int n) {
        int answer = n + 1;
        
        while (true) {
            if (getOneNum(n) == getOneNum(answer)) return answer;
            answer++;
        }
    }
    public int getOneNum(int input) {
        String binary = Integer.toBinaryString(input);
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') count++;
        }
        
        return count;
    }
}