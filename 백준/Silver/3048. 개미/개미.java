import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> list = new ArrayList<>();
        try {
            // 입력 받기
            String[] N = br.readLine().split(" ");
            String ant1 = br.readLine();
            String ant2 = br.readLine();
            int T = Integer.parseInt(br.readLine());
            // 첫 번째 개미 그룹은 뒤집기
            StringBuilder ants = new StringBuilder(new StringBuilder(ant1).reverse() + ant2);
            // 리스트에 넣기
            for (int i = 0; i < T; i++) {
                for (int ii = 0; ii < ants.length() - 1; ii++) {
                    // 연속된 위치에 서로 다른 그룹의 개미가 있을 경우 점프(교환) 시키기
                    // 중복이 없기에 해당 contains 메소드로 해당 개미 그룹에 알파벳이 존재하는지 확인
                    if (ant1.contains(String.valueOf(ants.charAt(ii))) && ant2.contains(String.valueOf(ants.charAt(ii + 1)))) {
                        char temp = ants.charAt(ii);
                        ants.setCharAt(ii, ants.charAt(ii + 1));
                        ants.setCharAt(ii + 1, temp);
                        ii++;
                    }
                }
            }
            // 출력
            bw.write(ants.toString());
            bw.flush();
            bw.close();
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}