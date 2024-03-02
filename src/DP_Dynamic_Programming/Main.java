package DP_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        int[][] dp = new int[length1 + 1][length2 + 1]; // 문자열이 비교되는 위치(str1.chatAt(i)와 str2.chatAt(j))에서의 LCS 길이의 최대값을 저장

        /*
        경우 1: str1.chatAt(i)가 LCS에 포함되지 않는 경우
        - str1[1 ~ i]와 str2[1 ~ j]의 LCS == str1[1 ~ i - 1]와 str2[1 ~ j]의 LCS
        => dp[i][j] = dp[i][j - 1]
        경우 2: str2.chatAt(j)가 LCS에 포함되지 않는 경우
        - str1[1 ~ i]와 str2[1 ~ j]의 LCS == str1[1 ~ i]와 str2[1 ~ j - 1]의 LCS
        => dp[i][j] = dp[i - 1][j]
        경우 3: str1.chatAt(i), str2.chatAt(j) 모두 LCS에 포함되는 경우
        - str1[1 ~ i]와 str2[1 ~ j]의 LCS == str1[1 ~ i - 1]와 str2[1 ~ j - 1]의 LCS + 1
        => dp[i][j] = dp[i - 1][j - 1] + 1
        */

        /* 예제 1

          A C A Y K P
        C 0 1 1 1 1 1
        A 1 1 2 2 2 2
        P 1 1 2 2 2 3
        C 1 2 2 2 2 3
        A 1 2 3 3 3 3
        K 1 2 3 3 4 4

        */
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // 해당 위치의 문자가 일치하면
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 해당 위치의 문자가 일치하지 않으면
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[length1][length2];
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(main.solution(str1, str2));
    }
}
