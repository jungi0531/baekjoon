class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        
        return answer;
    }
    public int dfs(int[] numbers, int target, int curIndex, int sum) {
        int count = 0;
        
        if (curIndex >= numbers.length) {
            if (target == sum) return 1;
            return 0;
        }
        
        count += dfs(numbers, target, curIndex + 1, sum + numbers[curIndex]);
        
        numbers[curIndex] = -numbers[curIndex];
        count += dfs(numbers, target, curIndex + 1, sum + numbers[curIndex]);
        numbers[curIndex] = -numbers[curIndex];
        
        // System.out.println("curIndex: " + curIndex + " count: " + count);
        return count;
    }
}