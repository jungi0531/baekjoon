class Solution {
    static int answer;
    static final int[][] fatique = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    
    public int solution(int[] picks, String[] minerals) {
        // 최소라는 말은 모든 경우를 탐색해야하는 거 아닌가? 아까처럼 그리디인 경우도 있다. 백트래킹으로 갈까
        // picks 배열이 다 0이 되거나 minerals.length까지 광물을 다 파는 경우까지 반복
        // 배열을 먼저 보면서 다이아가 많은 구간을 선정해서 파는 건 거의 불가능할 것으로 보임
        // 따라서 완전탐색으로 모든 경우 중 최소 값을 구함
        answer = Integer.MAX_VALUE;
        
        backtracking(picks, minerals, 0, 0);
        
        return answer;
    }
    public void backtracking(int[] picks, String[] minerals, int cur, int sum) {
        
        int noPicks = 0;
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                int ii = 0;
                int curSum = 0;
                
                while (ii < 5 && cur + ii < minerals.length) {
                    int curMineral = 0;
                    if (minerals[cur + ii].equals("diamond")) {
                        curMineral = 0;
                    } else if (minerals[cur + ii].equals("iron")) {
                        curMineral = 1;
                    } else {
                        curMineral = 2;
                    }
                    curSum += fatique[i][curMineral];
                    ii++;
                }
                
                // 광물 다 팜
                if (cur + ii == minerals.length) {
                    answer = Math.min(answer, sum + curSum);
                } else {
                    backtracking(picks, minerals, cur + ii, sum + curSum);
                }
                picks[i]++;
            } else {
                noPicks++;
            }
        }
         // 곡괭이 다 씀
        if (noPicks == 3) {
            answer = Math.min(answer, sum);
        }
    }
}