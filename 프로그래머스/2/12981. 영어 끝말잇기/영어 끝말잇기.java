import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        // 해시에 이전에 나온 단어 넣고 말하기 전 해당 단어가 있는지 보고 없으면 넣기
        // count % n 해서 답 구하면 되겠네
        int[] answer = new int[2];
        HashSet<String> hash = new HashSet<>();
        
        int count = 1;
        hash.add(words[0]);
        while (count < words.length && 
               words[count].charAt(0) == words[count - 1].charAt(words[count - 1].length() - 1) &&
               !hash.contains(words[count])) {
            hash.add(words[count]);
            count++;
        }
        if (count == words.length) return new int[]{0, 0};
        answer[0] = (count % n) + 1;
        answer[1] = (count / n) + 1;

        return answer;
    }
}