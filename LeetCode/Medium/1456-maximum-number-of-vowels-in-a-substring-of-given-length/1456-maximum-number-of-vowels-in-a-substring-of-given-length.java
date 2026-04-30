class Solution {
    public int maxVowels(String s, int k) {
        /**
        s 안 k 길이의 substring에 최대 모음 개수를 출력
        걍 슬라이딩 윈도우로 하면 될 거 같은데?
        길이가 아니라 k 개수 안에 모음 수 저장해놓고
        */
        String vowels = "aeiou";
        int count = 0;
        int max = 0;
        int left = 0;
        int right = k - 1;

        for (int i = 0; i < k; i++) {
            if (vowels.contains(String.valueOf(s.charAt(i)))) {
                count++;
            }
        }
        max = Math.max(max, count);

        for (int i = k; i < s.length(); i++) {
            // 왼쪽 땡기기
            if (vowels.contains(String.valueOf(s.charAt(left)))) count--;
            left++;

            // 오른쪽 땡기기
            right++;
            if (right >= s.length()) break;
            if (vowels.contains(String.valueOf(s.charAt(right)))) count++;

            max = Math.max(max, count);
        }

        return max;
    }
}