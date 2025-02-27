import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            // 입력 받기
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            String[] bundle = br.readLine().split(" ");
            // 필요한 티셔츠 묶음 주문 수 = 각 사이즈 별 주문 수가 0보다 작아질 때까지 -T를 하고 count++
            // 필요한 펜의 개수 = (N / P) 묶음과 (N % P) 개의 낱개
            int totalCount = 0;
            int bundleCount = 0;
            for (int i = 0; i < 6; i++) {
                totalCount += Integer.parseInt(input[i]);
                // 필요한 티셔츠 묶음 개수 구하기
                bundleCount += Integer.parseInt(input[i]) / Integer.parseInt(bundle[0]);
                if (Integer.parseInt(input[i]) % Integer.parseInt(bundle[0]) != 0)
                    bundleCount++;
            }
            // 출력하기
            bw.write(String.valueOf(bundleCount) + "\n");
            bw.write(String.valueOf(N / Integer.parseInt(bundle[1])) + " " + String.valueOf(N % Integer.parseInt(bundle[1]) + "\n"));
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}