import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        /**
        접두어가 있으면 다른 거 반환
        반복문 돌면서 전화번호 다 넣은 해시셋에 그게 있는지 확인
        */
        HashSet<String> hash = new HashSet<>();
        
        for (int i = 0; i < phone_book.length; i++) {
            hash.add(phone_book[i]);
        }
        
        for (int i = 0; i < phone_book.length; i++) {
            for (int ii = 1; ii < phone_book[i].length(); ii++) {
                if (hash.contains(phone_book[i].substring(0, ii))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}