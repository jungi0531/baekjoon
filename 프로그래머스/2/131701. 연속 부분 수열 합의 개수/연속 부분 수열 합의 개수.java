import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // 원형 수열이니까 길이가 1 ~ 길이 까지 반복문을 돌고
        // 각 반복문에서 중복 검증을 어떻게 하지?
        // 아 합을 넣어놓는 Set을 하나 만들어서 없으면 count++하고 넣기
        Set<Integer> result = new HashSet<>();
        
        for (int i = 1; i <= elements.length; i++) {
            // 해당 반복문만큼 첫 cur에 합을 넣어놓기
            int sum = 0;
            for (int ii = 0; ii < i; ii++) {
                sum += elements[ii];
            }
            // 길이만큼 반복
            for (int ii = 0; ii < elements.length; ii++) {
                // (ii + i) % elements.length 값을 추가 후 ii거 삭제
                sum += elements[(ii + i) % elements.length];
                sum -= elements[ii];
                if (!result.contains(sum)) {
                    result.add(sum);
                }
            }
        }
        return result.size();
    }
}