class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = new String[4];
        word[0] = "aya";
        word[1] = "ye";
        word[2] = "woo";
        word[3] = "ma";
        
        // 우선 string 개수만큼 반복문
        for (int i = 0; i < babbling.length; i++) {
            // 각 문자에서 aya, ye, woo, ma의 contains를 확인하고 해당 문자가 있으면 해당 문자의 길이 카운트
            // 카운트한 길이와 현재 문자의 길이가 같으면 발음 가능
            int totalLength = 0;
            for (int ii = 0; ii < 4; ii++) {

                if (babbling[i].contains(word[ii])) {
                    totalLength += word[ii].length();
                }
            }
            if (totalLength == babbling[i].length()) {
                answer++;
            }
        }
        
        return answer;
    }
}