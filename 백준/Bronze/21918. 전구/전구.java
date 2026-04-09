import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] bulbs = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			bulbs[i] = Integer.parseInt(st.nextToken());
		}

		//
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				// 1번 명령어, b번째 전구를 c로 변경한다
				bulbs[b] = c;
			} else if (a == 2) {
				// 2번 명령어, b번째부터 c번째까지의 전구 상태 변경
				for (int ii = b; ii <= c; ii++) {
					bulbs[ii] = bulbs[ii] == 0 ? 1 : 0;
				}
			} else if (a == 3) {
				// 3번 명령어, b번째부터 c번째까지의 전구를 끈다
				for (int ii = b; ii <= c; ii++) {
					bulbs[ii] = 0;
				}
			} else if (a == 4) {
				// 4번 명령어, b번째부터 c번째까지의 전구를 킨다.
				for (int ii = b; ii <= c; ii++) {
					bulbs[ii] = 1;
				}
			}
		}
		//
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i <= N; i++) {
			sb.append(bulbs[i] + " ");
		}
		System.out.println(sb.toString());
	}
}