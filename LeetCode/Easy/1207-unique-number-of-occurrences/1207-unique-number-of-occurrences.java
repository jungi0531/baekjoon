import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        /**
        arr에 있는 각 수의 개수가 유니크한지 개수가 유니크해야함
        해시맵에 각 수에 대한 개수를 저장하고 나중에 해시셋에 넣으면서 이미 있으면 false
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> hash = new HashSet<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (hash.contains(map.get(num))) return false;
            hash.add(map.get(num));
        }
        return true;
    }
}