class Solution {
    public boolean increasingTriplet(int[] nums) {
        /**
        그냥 그리디로 푸는 문제였음
        항상 다른 방법도 생각해보자
        */

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (first >= num) {
                first = num;
            } else if (second >= num) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }
}