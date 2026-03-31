class Solution {
    
    static String input;
    static String[] alpha = {"A", "E", "I", "O", "U"};
    static int count;
    static int answer;
    
    public int solution(String word) {
        input = word;
        dfs("");
        
        return answer;
    }
    public void dfs(String word) {
        if (word.equals(input)) {
            answer = count;
            return;
        }
        count++;
        if (word.length() >= 5) return;
        
        for (int i = 0; i < 5; i++) {
            dfs(word + alpha[i]);
        }
    }
}