class Solution {
    int solution(int[][] land) {
        
        for (int i = 1; i < land.length; i++) {
            for (int ii = 0; ii < 4; ii++) {
                int max = 0;
                max = Math.max(max, land[i - 1][(ii + 1) % 4]);
                max = Math.max(max, land[i - 1][(ii + 2) % 4]);
                max = Math.max(max, land[i - 1][(ii + 3) % 4]);
                land[i][ii] += max;
            }
        }
        int max = 0;
        for (int i = 0; i < 4; i++) {
            max = Math.max(max, land[land.length - 1][i]);
        }

        return max;
    }
}