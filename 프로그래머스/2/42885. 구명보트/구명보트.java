import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // people을 오름차순으로 정렬하고 limit만큼 넣으면 안 되나?
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[right] + people[left] <= limit) {
                left++;
            }
            right--;
            answer++;
        }
        
        return answer;
    }
}