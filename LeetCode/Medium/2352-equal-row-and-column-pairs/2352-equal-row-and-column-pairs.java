import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        /**
        같은 순서의 행렬 찾기
        해시맵에 row 넣어놓고 같은 거 있으면 개수만큼 더하기
        11 1
        1 11

        */
        int sum = 0;
        int n = grid.length;
        StringBuilder sb;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder("");
            for (int ii = 0; ii < n; ii++) {
                sb.append(grid[i][ii]).append(" ");
            }
            String arr = sb.toString();
            map.put(arr, map.getOrDefault(arr, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            sb = new StringBuilder("");
            for (int ii = 0; ii < n; ii++) {
                sb.append(grid[ii][i]).append(" ");
            }
            String arr = sb.toString();
            if (map.containsKey(arr)) {
                sum += map.get(arr);
            }
        }

        return sum;
    }
}