package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, h, answer;
    static int[] dx = { -1, 0, 1, 0, 0, 0 };
    static int[] dy = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };
    static int[][][] map, dis;
    static boolean[][][] visited;
    static Queue<int[]> q = new LinkedList<>();

    private void BFS() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[1];
            int nowY = now[2];
            int nowZ = now[0];

            for (int i = 0; i < 6; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                int nextZ = nowZ + dz[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || nextZ < 0 || nextZ >= h) continue;
                if (map[nextZ][nextX][nextY] == -1) continue;
                if (!visited[nextZ][nextX][nextY] && map[nextZ][nextX][nextY] == 0) {
                    visited[nextZ][nextX][nextY] = true;
                    map[nextZ][nextX][nextY] = 1;
                    dis[nextZ][nextX][nextY] = dis[nowZ][nowX][nowY] + 1;

                    q.offer(new int[] { nextZ, nextX, nextY });
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];
        dis = new int[h][n][m];
        visited = new boolean[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        outer:
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) {
                        break outer;
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (!visited[i][j][k] && map[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        q.offer(new int[] { i, j, k });
                    }
                }
            }
        }

        main.BFS();

        boolean flag = true;
        outer:
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) {
                        flag = false;
                        break outer;
                    }
                }
            }
        }

        if (flag) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        answer = Math.max(answer, dis[i][j][k]);
                    }
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}