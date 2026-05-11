import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        /**
        주어진 연산을 통해 word1을 word2로 만들 수 있으면 true, 아니면 false
        연산1: 존재하는 두 문자의 위치를 바꾼다.
        연산2: 모든 한 문자를 다른 한 문자로 바꾼다.
        따라서 각 문자의 개수가 같고, 둘다 상대 문자 다 가지고 있으면 된다.
        */
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        HashSet<Integer> hash1 = new HashSet<>();
        HashSet<Integer> hash2 = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < word1.length(); i++) {
            int word = word1.charAt(i);
            map1.put(word, map1.getOrDefault(word, 0) + 1);
            hash1.add(word);
        }
        for (int i = 0; i < word2.length(); i++) {
            int word = word2.charAt(i);
            map2.put(word, map2.getOrDefault(word, 0) + 1);
            hash2.add(word);
        }
        //
        for (int key : map1.keySet()) {
            list1.add(map1.get(key));
        }
        for (int key : map2.keySet()) {
            list2.add(map2.get(key));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        // System.out.println(list1.toString());
        // System.out.println(list2.toString());
        //
        return list1.equals(list2) && hash1.equals(hash2);
    }
}