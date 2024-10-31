class Solution {
    public int solution(String s) {
        int answer = 0;
        int i = 0;
        String result = "";
        String temp = "";
        
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                result += s.charAt(i);
                i++;
            }
            else {
                temp = "";
                while (true) {
                    temp += s.charAt(i);
                    i++;
                    if (temp.equals("one")) { result += "1"; break; }
                    else if (temp.equals("two")) { result += "2"; break; }
                    else if (temp.equals("three")) { result += "3"; break; }
                    else if (temp.equals("four")) { result += "4"; break; }
                    else if (temp.equals("five")) { result += "5"; break; }
                    else if (temp.equals("six")) { result += "6"; break; }
                    else if (temp.equals("seven")) { result += "7"; break; }
                    else if (temp.equals("eight")) { result += "8"; break; }
                    else if (temp.equals("nine")) { result += "9"; break; }
                    else if (temp.equals("zero")) { result += "0"; break; }
                }
            }
        }
        answer = Integer.valueOf(result);
        return answer;
    }
}