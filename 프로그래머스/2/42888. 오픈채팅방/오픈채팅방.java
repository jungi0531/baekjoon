import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 해당 유저 아이디가  닉네임을 변경하면 기존 아이디도 다 변경
        // 스택 같은 것도 필요없는 듯함.
        // 해시 맵에 해당 유저 아이디의 최종 닉네임을 저장해놓기
        // 그 후 명령어랑 유저 아이디만 보고 닉네임 넣어서 반환
        HashMap<String, String> map = new HashMap<>();
        int count = 0;
        
        for (int i = 0; i < record.length; i++) {
            String[] input = record[i].split(" ");
            
            if (input[0].equals("Enter") || input[0].equals("Change")) {
                if (input[0].equals("Change")) count++;
                // 이 전 유저 아이디와 닉이 변경 되었으면 다 변경
                // 현재 채팅방에 있는 유저 아이디 변경
                map.put(input[1], input[2]);
            }
        }
        //
        String[] answer = new String[record.length - count];
        
        count = 0;
        for (int i = 0; i < record.length; i++) {
            String[] input = record[i].split(" ");
            
            if (input[0].equals("Enter")) {
                answer[count++] = map.get(input[1]) + "님이 들어왔습니다.";
            } else if (input[0].equals("Leave")) {
                answer[count++] = map.get(input[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}