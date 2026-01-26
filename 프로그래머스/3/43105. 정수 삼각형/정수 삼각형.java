class Solution {
    public int solution(int[][] triangle) {
        
        for (int i = 1; i < triangle.length; i++) {
            for (int ii = 0; ii < triangle[i].length; ii++) {
                if (ii == 0) {
                    triangle[i][ii] += triangle[i - 1][ii];
                } else if (ii == triangle[i].length - 1) {
                    triangle[i][ii] += triangle[i - 1][ii - 1];
                } else {
                    // 가에가 아니면
                    triangle[i][ii] += Math.max(triangle[i - 1][ii], triangle[i - 1][ii - 1]);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < triangle[triangle.length - 1].length - 1; i++) {
            if (max < triangle[triangle.length - 1][i]) {
                max = triangle[triangle.length - 1][i];
            }
        }
        return max;
    }
}