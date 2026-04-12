class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int ii = 0;
        StringBuilder sb = new StringBuilder("");
        
        while (i < word1.length() || ii < word2.length()) {
            if (i < word1.length()) sb.append(word1.charAt(i++));
            if (ii < word2.length()) sb.append(word2.charAt(ii++));
        }
        
        return sb.toString();
    }
}