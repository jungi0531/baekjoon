class Solution {
    static int answer;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        for (int i = 0; i < dungeons.length; i++) {
            if (dungeons[i][0] <= k) {
                visited[i] = true;
                backtracking(k - dungeons[i][1], dungeons, 1);
                visited[i] = false;
            }
        }
        
        return answer;
    }
    public void backtracking(int k, int[][] dungeons, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                backtracking(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}