import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        /**
        최댓값 먼저 구하고 내 값 + 추가 캔들이 max와 크거나 같으면 true
        */
        List<Boolean> list = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            if (max <= candies[i] + extraCandies) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

        return list;
    }
}