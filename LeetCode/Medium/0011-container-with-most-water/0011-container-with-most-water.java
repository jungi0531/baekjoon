class Solution {
    public int maxArea(int[] height) {
        /**
        가장 큰 사각형의 크기 반환
        사각형의 크기: 두 선 중 짧은 거 * 두 선 사이의 길이
        
        양 끝에서 시작해서 left와 right를 좁히는데, 더 길이가 작은 걸 좁힌다.
        작은 길이가 넓이에 영향을 미치기 때문
        */
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            max = Math.max(max, area(height, left, right));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return max;
    }
    public int area(int[] arr, int left, int right) {
        return Math.min(arr[left], arr[right]) * (right - left);
    }
}