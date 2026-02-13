class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder("");
        
        int len = number.length() - k;
        for (int i = 0; i < number.length(); i++) {
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) < number.charAt(i) && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(number.charAt(i));
        }
        
        return sb.substring(0, len);
    }
}