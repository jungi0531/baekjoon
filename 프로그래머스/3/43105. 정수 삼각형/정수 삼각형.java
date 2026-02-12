class Solution {
    public int solution(int[][] triangle) {
        // 흠 max 값을 받아오도록 하면 되잖아
        // i면 그 다음의 i와 i + 1에 드갈 수 있다.
        // 가장자리 부분을 먼저 해놔야 하나
        int answer = 0;
        
        // 가장자리 미리 해놓기
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][triangle[i].length - 1] += triangle[i - 1][triangle[i - 1].length - 1];
        }
        for (int i = 1; i < triangle.length; i++) {
            for (int ii = 1; ii < triangle[i].length - 1; ii++) {
                triangle[i][ii] += Math.max(triangle[i - 1][ii - 1], triangle[i - 1][ii]);
            }
        }
        
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(answer, triangle[triangle.length - 1][i]);
        }
        
        return answer;
    }
}