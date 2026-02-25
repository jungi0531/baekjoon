class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        
        int count = 0;
        while (left <= right) {
            long row = left / n;
            long col = left % n;
            
            answer[count++] = (int)Math.max(row, col) + 1;
            left++;
        }
        
        return answer;
    }
}