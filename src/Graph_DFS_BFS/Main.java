package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, max;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] originalMap;
    static boolean[][] visited;

    private void makeWall(int wallCount) {
        if (wallCount == 3) {
            // copyMap을 만드는 이유
            // 벽이 3개 세워질 때마다 spreadVirus를 실행해야 하므로
            // 벽이 세워진 originalMap을 복사해서 써야 함
            int[][] copyMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copyMap[i][j] = originalMap[i][j];
                }
            }

            max = Math.max(max, spreadVirus(copyMap));
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originalMap[i][j] == 0 && !visited[i][j]) {
                    originalMap[i][j] = 1;
                    visited[i][j] = true;
                    makeWall(wallCount + 1);
                    originalMap[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }
    }

    private int spreadVirus(int[][] area) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if (area[nextX][nextY] != 0) continue;

                q.offer(new int[] { nextX, nextY });
                area[nextX][nextY] = 2;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 0) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        originalMap = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        main.makeWall(0);

        System.out.println(max);
    }
}