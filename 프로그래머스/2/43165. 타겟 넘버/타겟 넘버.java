class Solution {
    static int count;
    
    public int solution(int[] numbers, int target) {
        count = 0;
        
        // 현재가 +인 경우, -인 경우 있음
        dfs(numbers, target, 0, 0);
        
        return count;
    }
    public void dfs(int[] numbers, int target, int curIndex, int sum) {
        if (curIndex >= numbers.length) {
            if (target == sum) count++;
            return;
        }
        
        dfs(numbers, target, curIndex + 1, sum + numbers[curIndex]);
        dfs(numbers, target, curIndex + 1, sum - numbers[curIndex]);
    }
}