import java.util.*;

class Solution {
    public String solution(String s) {
        // 이 전이 공백 문자인 첫 문자 알파벳을 대문자로, 나머지는 소문자로.
        StringBuilder sb = new StringBuilder("");
        
        s = s.toLowerCase();
        
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || 
                (s.charAt(i - 1) == ' ' &&
                Character.isLetter(s.charAt(i)))) {
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else sb.append(s.charAt(i));
            
        }
        return sb.toString();
    }
}

// class Solution {
//     public String solution(String s) {
//         StringBuilder sb = new StringBuilder("");
//         boolean isFirst = true;
        
//         for (char c : s.toCharArray()) {
//             if (c == ' ') {
//                 isFirst = true;
//                 sb.append(c);
//             } else {
//                 if (isFirst) {
//                     isFirst = false;
//                     sb.append(Character.toUpperCase(c));
//                 } else {
//                     sb.append(Character.toLowerCase(c));
//                 }
//             }
//         }
        
        
//         return sb.toString();
//     }
// }