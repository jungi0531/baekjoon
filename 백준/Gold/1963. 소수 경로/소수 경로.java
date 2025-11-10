import java.io.*;
import java.util.*;

public class Main {
    static int A;
    static int B;
    static int result;
    static boolean[] isPrime = new boolean[10000];
    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 소수 찾아놓기 -> 에라토스테네스의 체
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < 10000; i++) {
            if (isPrime[i]) {
                for (int ii = i * i; ii < 10000; ii += i) {
                    isPrime[ii] = false;
                }
            }
        }
        //
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Arrays.fill(visited, false);
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            //
            bfs();
            bw.write(String.valueOf(result) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        int count = 0;
        q.add(A);
        visited[A] = true;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String remove = q.poll().toString();
                if (Integer.parseInt(remove) == B) {
                    result = count;
                    return;
                }
                for (int ii = 0; ii < 4; ii++) {
                    for (int iii = 0; iii < 10; iii++) {
                        // 이거 어케 함 ㅋㅋ
                        char[] temp = remove.toCharArray();
                        temp[ii] = (char)('0' + iii);
                        int num = Integer.parseInt(new String(temp));
                        //
                        if (isValidNum(num)) {
                            visited[num] = true;
                            q.add(num);
                        }
                    }
                }
            }
            count++;
        }
    }
    public static boolean isValidNum(int num) {
        if (num < 1000 || num > 9999 || !isPrime[num] || visited[num]) return false;
        return true;
    }
}