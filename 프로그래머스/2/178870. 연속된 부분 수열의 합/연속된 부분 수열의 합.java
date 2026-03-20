class Solution {
    public int[] solution(int[] sequence, int k) {
        // 슬라이딩 윈도우 문제
        // 합이 k인 가장 짧은 배열의 길이 구하기 start와 end
        // 가장 짧은 걸 구해야하기에 끝까지 가긴 가야함
        int start = 0;
        int end = -1;
        int sum = 0;
        int[] answer = new int[]{0, Integer.MAX_VALUE};
        while (true) {
            if (sum == k) {
                // System.out.println(start + " " + end);
                // 길이가 가장 짧은 합이 k인 수열이면 answer 교체
                if (end - start < answer[1] - answer[0]) {
                    answer[0] = start;
                    answer[1] = end;
                }
                end++;
                if (end >= sequence.length) break;
                sum += sequence[end];
            } else if (sum < k) {
                // 합이 k전이면 슬라이드 늘리기 -> end 추가
                end++;
                if (end >= sequence.length) break;
                sum += sequence[end];
            } else {
                // 합이 k보다 크면 슬라이드 줄이기 -> start 추가
                sum -= sequence[start];
                if (start >= sequence.length) break;
                start++;
            }
            // if (start >= sequence.length || end >= sequence.length) break;
        }
        
        return answer;
    }
}