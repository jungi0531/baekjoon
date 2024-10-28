class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0, yCount = 0;
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P' || s.charAt(i) == 'p') pCount++;
            else if (s.charAt(i) == 'Y' || s.charAt(i) == 'y') yCount++;
        }
        if (pCount != yCount) answer = false;

        return answer;
    }
}