class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // 이분 탐색으로 최솟값을 찾아야한다.
        // 그럼 특정 값으로 시작 후 이분 탐색으로 값을 맞추어 나가야 함
        long level = 0;
        long start = 1;
        long end = 100_000_000_000_000L;
        
        while (start <= end) {
            level = (start + end) / 2;
            long sum = times[0];    // diffs[0] = 1
            for (int i = 1; i < diffs.length; i++) {
                sum += times[i];
                if (diffs[i] > level) {
                    sum += (diffs[i] - level) * (times[i - 1] + times[i]);
                }
            }
            if (limit >= sum) {
                end = level - 1;
            } else {
                start = level + 1;
            }
        }
        
        return (int)start;
    }
}