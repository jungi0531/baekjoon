class Solution {
    static int count;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        count = -1;
        visited = new boolean[dungeons.length];
        
        backtracking(k, dungeons, 0);
        
        return count;
    }
    public void backtracking(int k, int[][] dungeons, int cur) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                backtracking(k - dungeons[i][1], dungeons, cur + 1);
                visited[i] = false;
            }
        }
        count = Math.max(count, cur);
    }
}