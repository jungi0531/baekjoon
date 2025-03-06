import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<Integer> hash = new HashSet<>();

        // 연산의 수 입력 받기
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("add")) {
                // 집합에 x 추가(이미 있으면 연산 무시)
                if (!hash.contains(Integer.parseInt(input[1])))
                    hash.add(Integer.parseInt(input[1]));
            } else if (input[0].equals("remove")) {
                // 집합에서 x 제거(없으면 연산 무시)
                if (hash.contains(Integer.parseInt(input[1])))
                    hash.remove(Integer.parseInt(input[1]));
            } else if (input[0].equals("check")) {
                // 집합에서 x 있으면 1, 없으면 0 출력
                if (hash.contains(Integer.parseInt(input[1])))
                    bw.write("1\n");
                else
                    bw.write("0\n");
            } else if (input[0].equals("toggle")) {
                // 집합에 x가 있으면 제거, 없으면 추가
                if (hash.contains(Integer.parseInt(input[1])))
                    hash.remove(Integer.parseInt(input[1]));
                else
                    hash.add(Integer.parseInt(input[1]));
            } else if (input[0].equals("all")) {
                // 집합을 {1, 2, ..., 20}으로 변경
                hash.clear();
                for (int ii = 0; ii < 20; ii++) {
                    hash.add(ii + 1);
                }
            } else if (input[0].equals("empty")) {
                // 집합을 공집합으로(비우기)
                hash.clear();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}