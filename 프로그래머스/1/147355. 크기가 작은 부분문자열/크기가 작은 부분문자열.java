class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        String temp;
    
        for (int i = 0; i <= t.length() - p.length(); i++) {
            temp = t.substring(i, i + p.length());
            if (Long.valueOf(temp) <= Long.valueOf(p)) answer++;
        }
        
        return answer;
    }
}