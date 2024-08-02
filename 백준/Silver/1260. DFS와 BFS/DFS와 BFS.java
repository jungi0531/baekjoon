import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] array;
    static int[] visited;
    static int N, M, V;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();

        // 배열 선언 및 초기화
        array = new int[N ][N];
        visited = new int[N ];
        for (int i = 0; i < N; i++) {
            visited[i] = 0;
            for (int j = 0; j < N; j++) {
                array[i][j] = 0;
            }
        }
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            array[a - 1][b - 1] = 1;
            array[b - 1][a - 1] = 1;
        }

        // 탐색 실행
        dfs(V - 1);
        for (int i  = 0; i < N; i++) {
            visited[i] = 0;
        }
        System.out.println();
        bfs(V - 1);

        scanner.close();
    }
    public static void dfs(int index) {
        if (visited[index] == 1) {
            return;
        }
        visited[index] = 1;
        System.out.print((index + 1) + " ");
        for (int i = 0; i < N; i++) {
            if (array[index][i] == 1) {
                dfs(i);
            }
        }
    }
    public static void bfs(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = 1;
        System.out.print((index + 1) + " ");
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < N; i++) {
                if (array[temp][i] == 1 && visited[i] == 0) {
                    q.add(i);
                    visited[i] = 1;
                    System.out.print((i + 1) + " ");
                }
            }
        }
    }
}