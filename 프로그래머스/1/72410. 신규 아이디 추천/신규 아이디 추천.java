class Solution {
    public String solution(String new_id) {
        // 1단계: 대문자 다 소문자로
        new_id = new_id.toLowerCase();
        // 2단계: 알파벳 소문자, 숫자, -, _, . 제외 모두 제거
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < new_id.length(); i++) {
            if (Character.isLetter((new_id.charAt(i))) ||
                Character.isDigit((new_id.charAt(i))) ||
                new_id.charAt(i) == '-' ||
                new_id.charAt(i) == '_' ||
                new_id.charAt(i) == '.') {
                sb.append(new_id.charAt(i));
            }
        }
        // 3단계: .이 여러개면 스킵
        new_id = sb.toString();
        sb = new StringBuilder("");
        for (int i = 0; i < new_id.length(); i++) {
            sb.append(new_id.charAt(i));
            if (new_id.charAt(i) == '.') {
                while (i + 1 < new_id.length() && new_id.charAt(i + 1) == '.') {
                    i++;
                }
            }
        }
        // 4단계: 처음이나 끝에 있는 마침표 없애기
        new_id = sb.toString();
        System.out.println(new_id);
        if (new_id.length() > 0 && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        // 5단계: 빈 문자열이면 a 넣기
        if (new_id.length() == 0) {
            new_id = "a";
        }
        // 6단계: 길이가 16이상이면 뒤에거 다 자르기. 자르고 마침표가 마지막에 있으면 제거
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        // 7단계: 길이가 2이하라면 마지막 문자를 길이가 3이 될 때까지 반복
        sb = new StringBuilder(new_id);
        while (sb.length() < 3) {
            sb.append(new_id.charAt(new_id.length() - 1));
        }
        
        return sb.toString();
    }
}