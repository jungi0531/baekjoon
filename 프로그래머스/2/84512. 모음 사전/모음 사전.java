import java.util.*;

class Solution {
    static List<String> list;
    static String[] order = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        list = new ArrayList<>();
        
        make("");
        
        return list.indexOf(word);
    }
    public void make(String s) {
        list.add(s);
        
        if (s.length() == 5) return;
        
        for (int i = 0; i < 5; i++) {
            make(s + order[i]);
        }
    }
}