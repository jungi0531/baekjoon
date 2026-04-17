import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        /**
        자기 인덱스 빼고 모든 값의 곱
        O(n)으로 끝내야하니까 각 인덱스마다 바로 구해야한다?
        0이 두 개 이상 있으면 다 0이고
        0이 하나 있는 경우 그 0 하나를 찾아야하는데
        나눗셈을 쓰지 말고 하라고??
        왼쪽 오른쪽 나눠서..
        */
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}