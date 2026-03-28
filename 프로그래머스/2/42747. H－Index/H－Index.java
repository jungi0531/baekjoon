import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // n 이상 수가 n 개인 n 찾기
        // 최댓값이라고 하니 0부터 시작해서 늘려가며 최대를 찾기
        // 1이면 1이상 수가 1개
        // 2이면 2이상 수가 2개
        // 그럼 오름차순 정렬하고
        // 특정 인덱스의 수 i일 때 i 포함 뒤의 수가 i개 있으면 됨
        // 특정 인덱스의 수 i일 때 i 포함 뒤의 수가 i보다 작으면 탈출
        // 0 0 4 4 의 경우
        // 1 이상 1개 이상
        // 2 이상 2개 이상 <-
        // 3 이상 3개 이상 아님
        int answer = 0;
        
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] < citations.length - i) break;
            answer = citations.length - i;
        }
        
        // for (int i = 0; i < citations.length; i++) {
        //     if (citations[i] >= citations.length - i + 1) {
        //         break;
        //     }
        //     //System.out.println(i);
        //     answer = citations.length - i;
        // }
        
        return answer;
    }
}