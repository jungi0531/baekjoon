class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder("");
        String answer = "";
        
        if (Character.isAlphabetic(s.charAt(0))) {
            sb.append(Character.toUpperCase(s.charAt(0)));
        } else {
            sb.append(s.charAt(0));
        }
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ' && Character.isAlphabetic(s.charAt(i))) {
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else if (Character.isAlphabetic(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            } else {
                sb.append(s.charAt(i));
            }
        }
        answer = sb.toString();
        
        return answer;
    }
}