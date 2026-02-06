class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        // 1이 될 때까지 반복
        while (!s.equals("1")) {
            // 무엇을 반복? 0을 다 제거하고 제거한 만큼 count++
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') count++;
            }
            answer[1] += count;
            s = s.replace("0", "");
            
            // 이후 1만 남은 s의 길이를 이진 수로 변환해 저장
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        
        return answer;
    }
}