import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int place = Integer.parseInt(st.nextToken());
            // 해시맵이 비었으면 걍 넣고 해시맵에 값이 있는데 값이 다르면 ++
            if (map.containsKey(cow) && map.get(cow) != place) {
                result++;
            }
            map.put(cow, place);
        }
        System.out.println(result);
    }
}