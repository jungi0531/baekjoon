import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // 처음 문자 + 처음 숫자 + 나머지
        // 문자는 대소문자 구분 X
        // 다 같을 경우 원래 입력 순서 유지
        // 걍 문자열 파싱 문제인 듯 헌디..
        Arrays.sort(files, (a, b) -> {
            // 여기서 정렬 기준 맞추기?
            // 우선 HEAD -> NUMBER -> TAIL 세 등분
            int aIndex = 0;
            int bIndex = 0;
            while (aIndex < a.length() && !Character.isDigit(a.charAt(aIndex))) aIndex++;
            while (bIndex < b.length() && !Character.isDigit(b.charAt(bIndex))) bIndex++;
            String aHead = a.substring(0, aIndex).toLowerCase();
            String bHead = b.substring(0, bIndex).toLowerCase();
            if (!aHead.equals(bHead)) {
                return aHead.compareTo(bHead);
            }
            // 이제 NUMBER 부분
            int aStart = aIndex;
            int bStart = bIndex;
            while (aIndex < a.length() && Character.isDigit(a.charAt(aIndex))) aIndex++;
            while (bIndex < b.length() && Character.isDigit(b.charAt(bIndex))) bIndex++;
            String aNumber = a.substring(aStart, aIndex);
            String bNumber = b.substring(bStart, bIndex);
            if (Integer.parseInt(aNumber) != Integer.parseInt(bNumber)) {
                return Integer.parseInt(aNumber) - Integer.parseInt(bNumber);
            }
            // 이제 TAIL 부분
            return 0;
        });
    
        return files;
    }
}