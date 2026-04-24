class Solution {
    public int solution(int[][] sizes) {
        /**
        그냥 가장 큰 거 만들지 말고 눕혀서 만들 수 있으면 그걸로
        걍 이차원 배열을 정렬하고 가장 큰 거를
        */
        int max = 0;
        int min = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                max = Math.max(max, sizes[i][0]);
                min = Math.max(min, sizes[i][1]);
            }
            else {
                max = Math.max(max, sizes[i][1]);
                min = Math.max(min, sizes[i][0]);
            }
        }
        return max * min;
    }
}