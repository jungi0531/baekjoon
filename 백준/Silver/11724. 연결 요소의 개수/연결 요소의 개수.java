import java.util.Scanner;

public class Main {
    static int N, M, count;
    static int[][] array;
    static int[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = 0;
        N = scanner.nextInt();  // 정점의 개수
        M = scanner.nextInt();  // 간선의 개수

        array = new int[N][N];
        visited = new int[N];
        for (int i = 0; i < N; i++) {
            visited[i] = 0;
            for (int j = 0; j < N; j++) {
                array[i][j] = 0;
            }
        }

        // M번 만큼 간선의 양 끝 점 입력 받기
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            array[u - 1][v - 1] = 1;
            array[v - 1][u - 1] = 1;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);

        scanner.close();
    }
    public static void dfs(int index) {
        if (visited[index] == 1) {
            return;
        }
        else {
            visited[index] = 1;
            for (int i = 0; i < N; i++) {
                if (array[index][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}
