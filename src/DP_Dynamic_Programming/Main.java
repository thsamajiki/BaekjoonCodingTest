package DP_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int[][] rgbCostArr) {
//        1번 집의 색은 2번 집의 색과 같지 않아야 한다.
//        N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
//        i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
        int answer;
        int length = rgbCostArr.length - 1;

        for (int i = 1; i < length; i++) {
            int red = rgbCostArr[i + 1][0];
            int green = rgbCostArr[i + 1][1];
            int blue = rgbCostArr[i + 1][2];

            rgbCostArr[i + 1][0] = Math.min(rgbCostArr[i][1], rgbCostArr[i][2]) + red;
            rgbCostArr[i + 1][1] = Math.min(rgbCostArr[i][0], rgbCostArr[i][2]) + green;
            rgbCostArr[i + 1][2] = Math.min(rgbCostArr[i][0], rgbCostArr[i][1]) + blue;
        }

        answer = Math.min(Math.min(rgbCostArr[length][0], rgbCostArr[length][1]), rgbCostArr[length][2]);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 집의 수

        int[][] arr = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(arr));
    }
}
