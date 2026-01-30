class Solution {
    public int solution(int storey) {
        // 1로 위로 가는게 빠른가 아래로 가는게 빠른가가 중요
        // 4면 아래로, 6이면 위로 가서 1을 10으로 만듦 
        // 따라서 작은 단위, % 10 한 값부터 맞춰나가야 한다.
        int answer = 0;
        // storey = 555;
        while (storey > 0) {
            if (storey % 10 == 5) {
                // 95 같은 경우에서는 5를 위로 올려야 최적이다.
                // 15 같은 경우에서는 5를 아래로 내려야 최적이다.
                // 이 두 경우를 조건문으로 나누려면
                // storey / 10 한 값이 위에 가깝냐 아래에 가깝냐다
                // storey / 10 한 값이 5이하면 밑으로, 아니면 위로
                if ((storey / 10) % 10 < 5) {
                    // 아래로
                    answer += (storey % 10);
                    System.out.println("밑");
                } else {
                    // 위로
                    answer += 10 - (storey % 10);
                    System.out.println("위");
                    storey += 10;
                }
            } else if (storey % 10 < 5) {
                // 밑으로
                answer += (storey % 10);
                System.out.println("밑");
            } else {
                // 위로
                answer += 10 - (storey % 10);
                System.out.println("위");
                storey += 10;
            }
            storey /= 10;
        }
        
        return answer;
    }
}