package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, answer;
    static int[] dx = { -1, 0, 1,  0 };
    static int[] dy = {  0, 1, 0, -1 };
    static int[][] map;
    static boolean[][] visited;

    public void DFS(int x, int y, int sum, int L) {
        if (L == 3) {
            System.out.println("L == 3 찍다! 이제 리턴!");
            System.out.println("sum: " + sum);
            answer = Math.max(answer, sum);
            System.out.println("=============");
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > M - 1) continue;

            if (!visited[nextX][nextY]) {

                // ㅜ 테트로미노 만들기 위해 1번째 칸에서 탐색을 한 번 더 진행
                if (L == 1) {
                    System.out.println("L == 1");
                    System.out.println("i: " + i);
                    System.out.println("x: " + x);
                    System.out.println("y: " + y);
                    System.out.println("nextX: " + nextX);
                    System.out.println("nextY: " + nextY);
                    System.out.println("sum: " + sum);
                    System.out.println("map[" + nextX + "][" + nextY + "]: " + map[nextX][nextY]);
                    visited[nextX][nextY] = true;
                    System.out.println("visited[" + x + "][" + y + "]: " + visited[x][y]);
                    System.out.println("visited[" + nextX + "][" + nextY + "]: " + visited[nextX][nextY]);
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < M; k++) {
                            System.out.print(visited[j][k] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("============");
                    DFS(x, y, sum + map[nextX][nextY], L + 1);
                    visited[nextX][nextY] = false;
                    System.out.println("visited[" + x + "][" + y + "]: " + visited[x][y]);
                    System.out.println("visited[" + nextX + "][" + nextY + "]: " + visited[nextX][nextY]);
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < M; k++) {
                            System.out.print(visited[j][k] + " ");
                        }
                        System.out.println();
                    }
                }
                System.out.println("- L == " + L);
                System.out.println("i: " + i);
                System.out.println("x: " + x);
                System.out.println("y: " + y);
                System.out.println("nextX: " + nextX);
                System.out.println("nextY: " + nextY);
                System.out.println("sum: " + sum);
                System.out.println("map[" + nextX + "][" + nextY + "]: " + map[nextX][nextY]);
                visited[nextX][nextY] = true;
                System.out.println("visited[" + x + "][" + y + "]: " + visited[x][y]);
                System.out.println("visited[" + nextX + "][" + nextY + "]: " + visited[nextX][nextY]);
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        System.out.print(visited[j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println("============");
                DFS(nextX, nextY, sum + map[nextX][nextY], L + 1);
                visited[nextX][nextY] = false;
                System.out.println("visited[" + x + "][" + y + "]: " + visited[x][y]);
                System.out.println("visited[" + nextX + "][" + nextY + "]: " + visited[nextX][nextY]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                main.DFS(i, j, map[i][j], 0);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }
}
