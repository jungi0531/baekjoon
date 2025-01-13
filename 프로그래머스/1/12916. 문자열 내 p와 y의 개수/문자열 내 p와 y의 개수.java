class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') count++;
            else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') count--;
        }
        if (count != 0) answer = false;

        return answer;
    }
}