package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public int solution(int[] requestArr, int M) {
        int left = 0;
        int right = Arrays.stream(requestArr).max().getAsInt();

        while (left <= right) {
            int mid = (left + right) / 2; // 상한액
            long budget = 0; // 상한액(mid)으로 얻을 수 있는 예산

            for (int i = 0; i < N; i++) {
                if (requestArr[i] > mid) budget += mid;
                else budget += requestArr[i];
            }

            if (budget <= M) left = mid + 1;
            else right = mid - 1;
        }

        return right;
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] requestArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            requestArr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        System.out.println(main.solution(requestArr, M));
    }
}