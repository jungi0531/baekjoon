class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            int temp = -1;
            for (int ii = i - 1; ii >= 0; ii--) {
                if (s.charAt(ii) == s.charAt(i)) {
                    temp = i - ii;
                    break;
                }
            }
            answer[i] = temp;
        }
        
        return answer;
    }
}