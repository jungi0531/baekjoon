class Solution {
    public boolean isSubsequence(String s, String t) {
        /**
        걍 s 포인터로 올리면서 t를 끝까지 탐색했을 때 s의 포인터도 끝까지 가냐
        */   
        int p = 0;

        for (int i = 0; i < t.length(); i++) {
            if (p >= s.length()) break;
            if (s.charAt(p) == t.charAt(i)) {
                p++;
            }
        }

        if (p == s.length()) return true;
        return false;
    }
}