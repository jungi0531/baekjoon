class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // 이진 탐색이다. 특정 level이라고 가정하고 걸린 시간이 limit보다 크면 level을 올리고 낮으면 level을 내리고 이진 탐색으로
        // 레벨 초기값 설정 -> 해결할 수 있는 최소 레벨을 찾아야 함
        long start = 1;
        long end = 100_000;
        int answer = 0;
        
        while (start <= end) {
            long curTime = 0;
            long level = (start + end) / 2;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= level) {
                    // 맞음
                    curTime += times[i];
                } else {
                    // 틀림
                    curTime += (diffs[i] - level) * (times[i - 1] + times[i]) + times[i];
                }
                if (curTime > limit) break;
            }
            if (curTime <= limit) {
                answer = (int)level;
                end = level - 1;
            } else {
                start = level + 1;
            }
        }
        
        return answer;
    }
}