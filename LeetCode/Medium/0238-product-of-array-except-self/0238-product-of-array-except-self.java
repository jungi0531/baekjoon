import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        /**
        자기 인덱스 빼고 모든 값의 곱
        O(n)으로 끝내야하니까 각 인덱스마다 바로 구해야한다?
        0이 두 개 이상 있으면 다 0이고
        0이 하나 있는 경우 그 0 하나를 찾아야하는데
        */
        int zeroCount = 0;
        int zeroIndex = 0;
        int prod = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            } else {
                prod *= nums[i];
            }
        }

        int[] result = new int[nums.length];

        if (zeroCount == 1) {
            result[zeroIndex] = prod;
        } else if (zeroCount == 0) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = prod / nums[i];
            }
        }

        return result;
    }
}