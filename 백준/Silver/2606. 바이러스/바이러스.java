import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;  // 출력 값

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n + 1]; // 각 컴퓨터가 연결되어 있는 pair 기록(1번 컴퓨터의 연결은 인덱스 1에 append)
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n + 1]; // 방문한 컴퓨터 기록 배열
        for (int i = 0; i < pair; i++) {
            String[] input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            list[n1].add(n2);
            list[n2].add(n1);
        }
        // ArrayList 배열을 만들고 각 번호(컴퓨터)에 연결되어 있는 번호(컴퓨터) 붙이고 1번부터 BFS 적용
        ArrayList<Integer> cur = new ArrayList<>();
        cur.add(1); // 1부터 시작
        // 더이상 cur에 아무것도 담기지 않을 때까지 -> 더이상 전파될 컴퓨터가 없을 때까지
        while (!cur.isEmpty()) {
            // cur의 첫 숫자를 꺼내서
            int temp = cur.remove(0);
            // 방문하지 않은 노드라면 방문 했음으로 바꾸고 count++
            // 방문 했으면 아무것도 하지 않고 그냥 remove 하는 겁니당
            if (visited[temp] == false) {
                count++;
                visited[temp] = true;
            }
            // 해당 숫자와 연결된 값들을 cur에 모두 저장 -> 해당 인덱스와 쌍을 이루는 컴퓨터들 cur에 저장(BFS)
            while (!list[temp].isEmpty()) {
                cur.add(list[temp].remove(0));
            }
        }
        // 출력 후 버퍼 닫기
        // 1 제외해야하기에 -1
        bw.write(String.valueOf(count - 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}