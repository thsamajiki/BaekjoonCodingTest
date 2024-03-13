package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[][] A;
    static boolean[][] visited;

    public void solution() {
        /*
        A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ← A[1][5]
           ↓                                       ↑
        A[2][1]   A[2][2] ← A[2][3] ← A[2][4]   A[2][5]
           ↓         ↓                   ↑         ↑
        A[3][1]   A[3][2] → A[3][3] → A[3][4]   A[3][5]
           ↓                                       ↑
        A[4][1] → A[4][2] → A[4][3] → A[4][4] → A[4][5]

        temp = A[0][0] 4 + 4 + 4 + 1
        A[0][0] = A[0][1]
        A[0][1] = A[0][2]
        A[0][2] = A[0][3]
        A[0][3] = A[1][3]
        A[1][3] = A[2][3]
        A[2][3] = A[3][3]
        A[3][3] = A[3][2]
        A[3][2] = A[3][1]
        A[3][1] = A[3][0]
        A[3][0] = A[0][2]
        A[0][2] = A[0][1]
        A[0][1] = temp

        temp = A[1][1] 2 + 2 + 1
        A[1][1] = A[1][2]
        A[1][2] = A[2][2]
        A[2][2] = A[2][1]
        A[2][1] = temp
        */

        for (int i = 0; i < R; i++) {
            int r1 = 0, r2 = N - 1;
            int c1 = 0, c2 = M - 1;

            while (r1 < r2 && c1 < c2) {
                int temp = A[r1][c1];

                // 윗변에서 왼쪽으로
                for (int c = c1; c < c2; c++) {
                    A[r1][c] = A[r1][c + 1];
                }
                // 오른쪽 변에서 위쪽으로
                for (int r = r1; r < r2; r++) {
                    A[r][c2] = A[r + 1][c2];
                }
                // 아랫변에서 오른쪽으로
                for (int c = c2; c > c1; c--) {
                    A[r2][c] = A[r2][c - 1];
                }
                // 왼쪽 변에서 아래쪽으로
                for (int r = r2; r > r1; r--) {
                    A[r][c1] = A[r - 1][c1];
                }

                A[r1 + 1][c1] = temp;

                r1 += 1;
                c1 += 1;
                r2 -= 1;
                c2 -= 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        main.solution();
    }
}
