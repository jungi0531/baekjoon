import java.util.*;

class Solution {
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length];
        
        // 타겟이 -니까 무조건 마이너스로 해야하고
        for (int i = 0; i < numbers.length; i++) {
            visited[i] = true;
            numbers[i] = -numbers[i];
            dfs(visited, numbers, target, i);
            numbers[i] = -numbers[i];
            visited[i] = false;
        }
        
        return count;
    }
    public void dfs(boolean[] visited, int[] arr, int target, int cur) {
        if (getSum(arr) == target) {
            //System.out.println(Arrays.toString(arr));
            count++;
            return ;
        }
        for (int i = cur; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[i] = -arr[i];
                dfs(visited, arr, target, i);
                arr[i] = -arr[i];
                visited[i] = false;
            }
        }
    }
    public int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        
        return sum;
    }
}