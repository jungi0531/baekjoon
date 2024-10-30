class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = 0;
        char temp = ' ';
        
        for (int i = 0; i < s.length(); i++) {
            if (count == 0) {
                temp = s.charAt(i);
                answer++;
                count++;
            } else {
                if (temp == s.charAt(i)) count++;
                else count--;
            }
        }
        
        return answer;
    }
}