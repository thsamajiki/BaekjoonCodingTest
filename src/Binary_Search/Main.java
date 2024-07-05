package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        long[] lans = new long[K];

        long min = 1; // 가장 짧은 랜선의 길이
        long max = 0; // 가장 긴 랜선의 길이

        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine()); // 이미 가지고 있는 각 랜선의 길이
            max = Math.max(max, lans[i]);
        }

        while (min <= max) {
            long totalCount = 0;
            long mid = (min + max) / 2;

            for (int i = 0; i < K; i++) {
                totalCount += lans[i] / mid;
            }

            // mid 길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
            // 자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
            // 그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.

            // 등호를 포함시키는 이유
            // 등호가 없으면, totalCount가 정확히 N인 경우에 더 큰 길이를 시도하지 않게 되므로 최적의 길이를 찾지 못할 수 있다.
            if (totalCount >= N) {
                min = mid + 1; // 더 긴 랜선 길이를 시도한다.
            } else {
                max = mid - 1; // 랜선 길이를 줄인다
            }
        }

        System.out.println(max);
    }
}