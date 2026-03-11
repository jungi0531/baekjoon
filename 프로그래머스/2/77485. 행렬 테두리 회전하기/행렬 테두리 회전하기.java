class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        // 각 회전마다 가장 작은 수를 출력하라고 하면 그래도 한번 다 훑어야 하는 거 아님?
        // 입력 최댓값 작은 거 보니까 다 봐야하는 거 같은데 ㄹㅇ
        // 우선 이차원 배열을 만들어서 직접 넣어놔야겠네
        // 그리고 각 점부터 시작해서 테두리 값을 이동..?
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int ii = 0; ii < columns; ii++) {
                arr[i][ii] = (i * columns) + ii + 1;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            
            int start = arr[x1][y1];
            int min = Integer.MAX_VALUE;
            for (int ii = x1; ii < x2; ii++) {
                min = Math.min(min, arr[ii][y1]);
                arr[ii][y1] = arr[ii + 1][y1];
            }
            for (int ii = y1; ii < y2; ii++) {
                min = Math.min(min, arr[x2][ii]);
                arr[x2][ii] = arr[x2][ii + 1];
            }
            for (int ii = x2; ii > x1; ii--) {
                min = Math.min(min, arr[ii][y2]);
                arr[ii][y2] = arr[ii - 1][y2];
            }
            for (int ii = y2; ii > y1; ii--) {
                min = Math.min(min, arr[x1][ii]);
                arr[x1][ii] = arr[x1][ii - 1];
            }
            arr[x1][y1 + 1] = start;

            answer[i] = min;
        }
        
        return answer;
    }
}