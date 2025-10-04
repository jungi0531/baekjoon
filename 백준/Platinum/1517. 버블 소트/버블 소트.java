import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] sorted;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sorted = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //
        mergeSort(0, N - 1);
        // 출력
        System.out.println(count);
    }
    public static void mergeSort(int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        merge(start, mid, end);
    }
    public static void merge(int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int index = start;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                sorted[index++] = arr[i++];
            }
            else {
                sorted[index++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid)
            sorted[index++] = arr[i++];
        while (j <= end)
            sorted[index++] = arr[j++];
        for (int k = start; k <= end; k++)
            arr[k] = sorted[k];
    }
}