class Solution {
    public int largestAltitude(int[] gain) {
        /**
        앞에서부터 차례로 더하면서 가장 큰 값을 반환
        */
        int max = 0;
        int sum = 0;
        
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}