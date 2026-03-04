import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 각각 해시맵을 만들어서 넣고
        // 합집합 해시맵은 max 값 저장
        // 교집합 해시맵은 min 값 저장
        HashMap<String, Integer> hash1 = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String temp = str1.substring(i, i + 2).toUpperCase();
            // 영어만 들어있지 않으면 버려야 함
            if (('A' <= temp.charAt(0) && temp.charAt(0) <= 'Z') &&
                ('A' <= temp.charAt(1) && temp.charAt(1) <= 'Z')) {
                hash1.put(temp, hash1.getOrDefault(temp, 0) + 1);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String temp = str2.substring(i, i + 2).toUpperCase();
            if (('A' <= temp.charAt(0) && temp.charAt(0) <= 'Z') &&
                ('A' <= temp.charAt(1) && temp.charAt(1) <= 'Z')) {
                hash2.put(temp, hash2.getOrDefault(temp, 0) + 1);
            }
        }
        // 둘다 공집합인 경우
        if (hash1.size() == 0 && hash2.size() == 0) return 65536;
        
        // 교집합 구하고 합쳐서 합집합 구하기
        double union = 0;
        double inter = 0;
        for (String temp : hash1.keySet()) {
            if (hash2.containsKey(temp)) {
                union += Math.max(hash1.get(temp), hash2.get(temp));
                inter += Math.min(hash1.get(temp), hash2.get(temp));
            } else {
                union += hash1.get(temp);
            }
        }
        for (String temp : hash2.keySet()) {
            if (!hash1.containsKey(temp)) {
                union += hash2.get(temp);
            }
        }
        
        return (int)(inter / union * 65536);
    }
}