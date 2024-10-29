class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        String temp;
    
        for (int i = 0; i <= t.length() - p.length(); i++) {
            temp = "";
            for (int j = i; j < i + p.length(); j++) {
                temp += t.charAt(j);
            }
            // System.out.println(temp);
            if (Long.valueOf(temp) <= Long.valueOf(p)) answer++;
        }
        
        return answer;
    }
}