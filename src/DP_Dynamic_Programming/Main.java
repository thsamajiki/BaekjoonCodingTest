package DP_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Consulting {
    int days;
    int money;

    public Consulting(int days, int money) {
        this.days = days;
        this.money = money;
    }
}

public class Main {
    static Consulting[] arr;

    public int solution(int N) {
        int[] dp = new int[N + 2]; // 날짜 i부터 상담을 했을 때 벌 수 있는 돈의 최댓값
        // 날짜의 마지막 날부터 첫 날까지 거꾸로 dp 배열을 구해나간다.
        // 예를 들어 dp[5]는 5일부터 일한 값 중 최댓값이다.
        // dp[1]은 마지막 날의 상담을 골라서 했을 때 벌 수 있는 돈의 최댓값
        // 그러므로 dp[1]을 구해주면 된다.

        for (int i = N; i >= 1; i--) {
            int next = i + arr[i].days;

            if (next > N + 1) { // 상담할 수 있는 날짜를 넘어가는 경우
                dp[i] = dp[i + 1]; // 그 전의 상담 가능한 일자의 돈의 최댓값을 가져옴
            } else { // 상담할 수 있는 날짜인 경우
                // 1. 상담하지 않았을 때(dp[i + 1])
                // 2. 상담했을 때 총 벌 수 있는 금액(arr[i].money + dp[next])
                // 위 두 경우 중 더 큰 값을 dp에 넣어준다.
                dp[i] = Math.max(dp[i + 1], arr[i].money + dp[next]);
            }
        }

        return dp[1];
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new Consulting[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            arr[i] = new Consulting(days, money);
        }

        System.out.println(main.solution(N));
    }
}
