import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        // 아직 나오면 안 되는 것들을 담아놓는 셋?
        // BD를 셋에 넣어놓고 C가 나오면 B 빼기?
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            HashSet<Character> hash = new HashSet<>();
            for (int ii = 0; ii < skill.length(); ii++) {
                hash.add(skill.charAt(ii));
            }
            int count = 0;
            boolean impossible = false;
            //
            for (int ii = 0; ii < skill_trees[i].length(); ii++) {
                if (hash.contains(skill_trees[i].charAt(ii))) {
                    if (skill.charAt(count) == skill_trees[i].charAt(ii)) {
                        hash.remove(skill.charAt(count));
                        count++;
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }
            //
            if (!impossible) {
                answer++;
            }
        }
        
        return answer;
    }
}