import java.io.*;
import java.util.*;

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Node> list = new ArrayList<>();

        // 입력
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            Node newNode = new Node((char)('A' + i));
            list.add(newNode);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node parent = list.get(data - 'A');
            if (left == '.')
                parent.left = null;
            else
                parent.left = list.get(left - 'A');
            if (right == '.')
                parent.right = null;
            else
                parent.right = list.get(right - 'A');

        }
        //
        preOrder(list.get(0));
        sb.append("\n");
        inOrder(list.get(0));
        sb.append("\n");
        postOrder(list.get(0));
        // 출력
        System.out.println(sb);
    }
    public static void preOrder(Node start) {
        if (start == null)
            return;
        sb.append(start.data);
        preOrder(start.left);
        preOrder(start.right);
    }
    public static void inOrder(Node start) {
        if (start == null)
            return;
        inOrder(start.left);
        sb.append(start.data);
        inOrder(start.right);
    }
    public static void postOrder(Node start) {
        if (start == null)
            return;
        postOrder(start.left);
        postOrder(start.right);
        sb.append(start.data);
    }
}