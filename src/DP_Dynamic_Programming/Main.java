package DP_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] stairs;

    public int solution(int[] stairs) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[1] = stairs[1];

        if (n >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        if (n >= 3) {
            dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
        }

        if (n >= 4) {
            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
            }
        }

        answer = dp[n];

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        stairs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(main.solution(stairs));
    }
}
