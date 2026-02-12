import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> hash = new HashSet<>();
        
        for (int i = 0; i < phone_book.length; i++) {
            hash.add(phone_book[i]);
        }
        
        for (String temp : hash) {
            for (int i = 1; i < temp.length(); i++) {
                if (hash.contains(temp.substring(0, i))) return false;
            }
        }
        
        return true;
    }
}