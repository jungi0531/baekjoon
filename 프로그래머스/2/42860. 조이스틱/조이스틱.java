class Solution {
    public int solution(String name) {
        // 그냥 각각 해야하는 거 아녀?
        // 한 숫자에 최대 13번 가능 m 기준
        int answer = 0;
        int move = Integer.MAX_VALUE;
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, 
                            Math.min(i * 2 + name.length() - next, 
                                     (name.length() - next) * 2 + i));
        }
        
        return answer + move;
    }
}