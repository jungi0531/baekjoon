import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] input = s.split("\\},\\{");
        
        Arrays.sort(input, (a, b) -> {
            return a.length() - b.length();
        });
        HashSet<Integer> hash = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < input.length; i++) {
            String[] temp = input[i].split(",");
            for (int ii = 0; ii < temp.length; ii++) {
                int cur = Integer.parseInt(temp[ii]);
                if (!hash.contains(cur)) {
                    arr.add(cur);
                    hash.add(cur);
                }
            }
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}