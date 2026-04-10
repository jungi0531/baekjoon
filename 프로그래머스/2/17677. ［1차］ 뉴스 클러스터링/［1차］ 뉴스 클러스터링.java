import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 해시를 활용해야할 듯 두 글자씩 끊어서 자카드 검사를 진행이라
        // 일단 두 글자씩 자르는데 모두 문자여야 함
        // 교집합은 해시셋으로 하고
        // 합집합은
        // 아니다 걍 해시맵에다가 해당 자카다의 개수까지 같이 저장하면 될 듯
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String temp = str1.substring(i, i + 2).toUpperCase();
            if (!(Character.isLetter(temp.charAt(0)) && Character.isLetter(temp.charAt(1)))) continue;
            map1.put(temp, map1.getOrDefault(temp, 0) + 1);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String temp = str2.substring(i, i + 2).toUpperCase();
            if (!(Character.isLetter(temp.charAt(0)) && Character.isLetter(temp.charAt(1)))) continue;
            map2.put(temp, map2.getOrDefault(temp, 0) + 1);
        }
        if (map1.size() == 0 && map2.size() == 0) return 65536;
        int inter = 0;
        int union = 0;
        for (String temp : map1.keySet()) {
            if (map2.containsKey(temp)) {
                // 둘 다 있으면 max 값이 합집합 min 값이 교집합
                inter += Math.min(map1.get(temp), map2.get(temp));
                union += Math.max(map1.get(temp), map2.get(temp));
            } else {
                // 얘만 있는 거면 합집합에 걍 추가
                union += map1.get(temp);
            }
        }
        // 이제 map2에만 있는 거 합집합에 추가
        for (String temp : map2.keySet()) {
            if (!map1.containsKey(temp)) {
                union += map2.get(temp);
            }
        }
        //System.out.println(inter + " " + union);
        
        int answer = 65536 * inter / union;
        
        return answer;
    }
}