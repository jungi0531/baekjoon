class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] input = s.split(" ");
        for (int i = 0 ; i < input.length; i++) {
            max = Math.max(max, Integer.parseInt(input[i]));
            min = Math.min(min, Integer.parseInt(input[i]));
        }
        answer = Integer.toString(min) + " " + Integer.toString(max);
        
        return answer;
    }
}