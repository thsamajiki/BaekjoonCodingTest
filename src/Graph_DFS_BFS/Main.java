package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, normal, abnormal;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static char[][] map;
    static boolean[][] visited;

    private void DFS(int x, int y) {
        char color = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX > n - 1 || nextY < 0 || nextY > n - 1) continue;
            if (map[nextX][nextY] == color && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                DFS(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                char ch = temp.charAt(j);
                map[i][j] = ch;
            }
        }

        // 정상인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    normal++;
                    visited[i][j] = true;
                    main.DFS(i, j);
                }
            }
        }

        // 적록색약
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    abnormal++;
                    visited[i][j] = true;
                    main.DFS(i, j);
                }
            }
        }

        System.out.println(normal + " " + abnormal);
    }
}