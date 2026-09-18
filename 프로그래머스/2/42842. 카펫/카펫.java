class Solution {
    public int[] solution(int brown, int yellow) {
        // 테두리는 갈색, 내부는 노란색. 각각 개수가 주어질 때 총 크기를 구해라.
        // 갈색 노란색 칸의 합이 총 개수의 곱이랑 같다.
        // 가로 세로 최소 3부터..
        
        int sum = brown + yellow;
        
        for (int i = 3; i < sum; i++) {
            if (sum % i == 0) {
                int x = i;
                int y = sum / i;
                if ((x - 2) * (y - 2) == yellow) {
                    return new int[]{y, x};
                }
            }
        }
        return new int[]{};
    }
}