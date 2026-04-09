class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        // 각 줄의 수를 & 한 다음에 해당 수를 이진수로 바꾸고 1 자리는 # 넣기
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        StringBuilder sb;
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder("");
            for (int ii = 0; ii < n - answer[i].length(); ii++) {
                sb.append(" ");
            }
            for (int ii = 0; ii < answer[i].length(); ii++) {
                if (answer[i].charAt(ii) == '0') {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}