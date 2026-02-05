class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 오프닝 구간 확인
        if (toMinute(op_start) <= toMinute(pos) && toMinute(pos) < toMinute(op_end)) {
            pos = op_end;
        }
        
        int cur = toMinute(pos);
        
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("next")) {
                if (cur + 10 > toMinute(video_len)) {
                    cur = toMinute(video_len);
                } else {
                    cur += 10;
                }
            } else if (commands[i].equals("prev")) {
                if (cur - 10 < 0) {
                    cur = 0;
                } else {
                    cur -= 10;
                }
            }
            if (toMinute(op_start) <= cur && cur < toMinute(op_end)) {
                cur = toMinute(op_end);
            }
        }
        
        
        return toVideo(cur);
    }
    public int toMinute(String input) {
        String[] temp = input.split(":");
        
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
    public String toVideo(int input) {
        String hour = "";
        String minute = "";
        if (input / 60 >= 10) {
            hour = Integer.toString(input / 60);
        } else {
            hour = "0" + Integer.toString(input / 60);
        }
        if (input % 60 >= 10) {
            minute = Integer.toString(input % 60);
        } else {
            minute = "0" + Integer.toString(input % 60);
        }
        
        return hour + ":" + minute;
    }
}