import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        
        if (!stack.isEmpty()) return false;
        return true;
    }
}

// import java.util.*;

// class Solution {
//     boolean solution(String s) {
//         Stack<Integer> stack = new Stack<>();
        
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') stack.push(0);
//             else {
//                 if (stack.isEmpty()) return false;
//                 stack.pop();
//             }
//         }
        
//         if (!stack.isEmpty()) return false;
//         return true;
//     }
// }