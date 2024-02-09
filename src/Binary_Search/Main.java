package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // N: 나무의 수, M: 집으로 가져가려고 하는 나무의 길이

    public long solution(long[] heights) {
        Arrays.sort(heights);

        long left = 0; // 절단기 최소 높이
        long right = heights[N - 1]; // 절단기 최대 높이

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for(long height: heights) {
                if (height > mid) sum += height - mid;
            }

            if (sum >= M) left = mid + 1;
            else right = mid - 1;
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long[] heights = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(heights));
    }
}
