import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    static HashSet<Integer> hash;
    
    public int solution(String numbers) {
        // 각 종이에 있는 걸
        // 탐색을 하면서 그 때 해당 수가 소수면 count++;
        // 우선 한 자리 수씩 끼워 넣는 것이므로 String 그대로 사용
        // 최대 7!이니까 완전 탐색으로 구하기 시간 복잡도 신경 X
        // visited 및 현재 수 관리 필요함 
        answer = 0;
        visited = new boolean[numbers.length()];    // 사용한 숫자 다시 사용 X
        hash = new HashSet<>(); // 중복 소수 카운트 방지 해시
        
        dfs(numbers, "");
        
        return answer;
    }
    public void dfs(String numbers, String curNum) {
        
        for (int i = 0; i < numbers.length(); i++) {
            // 아직 쓰지 않는 카드 드가서 
            if (!visited[i]) {
                visited[i] = true;
                int num = Integer.parseInt(curNum + numbers.charAt(i));
                if (isPrime(num) && !hash.contains(num)) {
                    System.out.println(num);
                    hash.add(num);
                    answer++;
                }
                dfs(numbers, curNum + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    public boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}