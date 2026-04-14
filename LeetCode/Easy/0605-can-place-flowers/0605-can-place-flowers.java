class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /**
        일단은 0이 나오면 전 칸이 0이면 심고 1이면 못 심음 이걸 반복
        근데? 앞 칸에 미리 있는 경우도 봐야해
        */

        for (int i = 0; i < flowerbed.length; i++) {
            int left = Math.max(0, i - 1);
            int right = Math.min(flowerbed.length - 1, i + 1);

            if (flowerbed[left] == 0 && flowerbed[i] == 0 && flowerbed[right] == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }
        if (n > 0) return false;
        return true;
    }
}