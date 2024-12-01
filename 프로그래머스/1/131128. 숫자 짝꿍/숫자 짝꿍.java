import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        int[] xArray = new int[10];
        int[] yArray = new int[10];
        
        for (char x : X.toCharArray()) {
            xArray[x - '0']++;
        }
        for (char y : Y.toCharArray()) {
            yArray[y - '0']++;
        }
        
        for (int i = 9; i >= 0; i--) {
                for (int ii = 0; ii < Math.min(xArray[i], yArray[i]); ii++) {
                    answer.append(i);
                }
            }
        
        if (answer.toString().isEmpty()) return "-1";
        else if (answer.toString().replace("0", "").isEmpty()) return "0";
        
        return answer.toString();
    }
}