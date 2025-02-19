import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            // 테스트 케이스 수 입력 받기
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                // 세준 세비 병사 입력 받기
                br.readLine();
                String[] input = br.readLine().split(" ");
                // 결국엔 가장 강한 병사가 있는 쪽이 이기기에, 입력 값을 반복문으로 돌면서 MAX 값 구하기
                int S = Integer.MIN_VALUE;
                int B = Integer.MIN_VALUE;
                String[] temp = br.readLine().split(" ");
                for (int ii = 0; ii < Integer.parseInt(input[0]); ii++) {
                    if (Integer.parseInt(temp[ii]) > S)
                        S = Integer.parseInt(temp[ii]);
                }
                String[] temp2 = br.readLine().split(" ");
                for (int ii = 0; ii < Integer.parseInt(input[1]); ii++) {
                    if (Integer.parseInt(temp2[ii]) > B)
                        B = Integer.parseInt(temp2[ii]);
                }
                // 누가 이긴지 출력 -> MAX 비교 후 큰 쪽 출력
                if (S >= B)
                    bw.write("S\n");
                else
                    bw.write("B\n");
            }
            bw.flush();
            bw.close();
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}