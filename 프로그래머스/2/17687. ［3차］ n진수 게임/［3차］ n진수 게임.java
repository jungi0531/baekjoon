class Solution {
    public String solution(int n, int t, int m, int p) {
        /*
        ㄹㅇ 벽 느껴지네 어케 푸노.. 
        t 길이의 문자열을 리턴해야함.
        입력 형식 값이 작은 거 보니 DP 같은 건 아니고 노가다 코딩을 해야하는 거 같긴 한데
        */
        String number = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder("");
        StringBuilder answer = new StringBuilder("");
        
        int i = 0;
        while (sb.length() < t * m) {
            sb.append(Integer.toString(i, n).toUpperCase());
            i++;
        }
        i = 0;
        while (answer.length() < t) {
            if ((i % m) + 1 - p == 0) answer.append(sb.charAt(i));
            i++;
        }
        
        return answer.toString();
    }
}