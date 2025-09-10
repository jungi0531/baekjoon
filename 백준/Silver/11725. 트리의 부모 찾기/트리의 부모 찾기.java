import java.io.*;
import java.util.*;

class Node {
    int data = 0;
    Node parent = null;
    Node left = null;
    Node right = null;
    public Node(int data) {
        this.data = data;
    }
}

class Edge implements Comparable<Edge>{
    int a;
    int b;

    public Edge(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Edge e1) {
        return this.a - e1.a;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        //
        int[] parent = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parent[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (parent[next] == 0) {
                    parent[next] = cur;
                    q.add(next);
                }
            }
        }
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}