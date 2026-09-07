class Solution {
    public int[] solution(String s) {
        // 1의 개수의 수를 바이너리로 변환
        int[] answer = new int[2];
        int count = 0;
        StringBuilder sb;
        
        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') count++;
            }
            answer[1] += s.length() - count;

            // count를 이진 수로 변환
            sb = new StringBuilder("");
            while (count > 0) {
                if (count % 2 == 1) sb.append(1);
                else sb.append(0);
                count /= 2;
            }
            s = sb.toString();
            answer[0]++;
        }
        
        
        return answer;
    }
}
// class Solution {
//     public int[] solution(String s) {
//         int[] answer = new int[2];
        
//         // 1이 될 때까지 반복
//         while (!s.equals("1")) {
//             // 무엇을 반복? 0을 다 제거하고 제거한 만큼 count++
//             int count = 0;
//             for (int i = 0; i < s.length(); i++) {
//                 if (s.charAt(i) == '0') count++;
//             }
//             answer[1] += count;
            
//             // 이후 1만 남은 s의 길이를 이진 수로 변환해 저장
//             int num = s.length() - count;
//             StringBuilder sb = new StringBuilder("");
//             while (num > 0) {
//                 sb.append(num % 2);
//                 num /= 2;
//             }
//             s = sb.toString();
//             answer[0]++;
//         }
        
//         return answer;
//     }
// }

