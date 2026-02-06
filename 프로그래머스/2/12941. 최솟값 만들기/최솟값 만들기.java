import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        // 최소가 되게 하려면 최솟값 * 최댓값으로 해야한다 그러려면 A는 오름차순 정렬, B는 내림차순 정렬을 하고 순서대로 곱하면 될 듯
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - (i + 1)];
        }

        return answer;
    }
}