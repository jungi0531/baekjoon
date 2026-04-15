class Solution {
    public String reverseVowels(String s) {
        /**
        모음들의 순서를 뒤집기
        자음은 앞에서부터 걍 추가하고
        모음은 뒤에서부터 온다?
        앞에서부터 넣다가 모음 발견하면 뒤에 첫 번째 모음을 넣고 앞으로 옮긴다.
        */
        String vowels = "aeiouAEIOU";
        int vowelNum = s.length();
        while (true) {
            vowelNum--;
            if (vowelNum < 0 || vowels.contains(Character.toString(s.charAt(vowelNum)))) break;
        }
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(Character.toString(s.charAt(i)))) {
                sb.append(s.charAt(vowelNum));
                while (true) {
                    vowelNum--;
                    if (vowelNum < 0 || vowels.contains(Character.toString(s.charAt(vowelNum)))) break;
                }
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}