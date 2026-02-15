class Solution {
    public int solution(int[] arr) {
        // i++ 하면서 다 0 되는 거 찾기? 이진 탐색인가
        int answer = 2;
        
        boolean isAnswer = true;
        while (true) {
            isAnswer = true;
            
            for (int i = 0; i < arr.length; i++) {
                if (answer % arr[i] != 0) {
                    isAnswer = false;
                    break;
                }
            }
            
            if (isAnswer) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}