class Solution {
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        // 던전을 탐험하기 위해 어떻게 하냐는 것인데..
        // 내가 봤을 때 다 해보는 수밖에 없다.
        // 어떻게 다 해보느냐,
        boolean[] visited = new boolean[dungeons.length];
        
        search(dungeons, visited, 0, k);
        
        return answer;
    }
    public void search(int[][] dungeons, boolean[] visited, int level, int cur) {
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && cur >= dungeons[i][0]) {
                visited[i] = true;
                search(dungeons, visited, level + 1, cur - dungeons[i][1]);
                visited[i] = false;
            }
        }
        
        if (level > answer) {
            System.out.println("level: " + level + " " + "cur: " + cur);
            answer = level;
        }
    }
}