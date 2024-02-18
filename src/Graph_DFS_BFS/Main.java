package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, answer;
    static int[] dx = { -1, 0, 1,  0 };
    static int[] dy = {  0, 1, 0, -1 };
    static int[][] map;
    static boolean[][] visited;

    public int bfs(int[][] map) {
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.offer(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > M - 1) continue;

                if (map[nextX][nextY] == 0) {
                    map[nextX][nextY] = 2;
                    q.offer(new Point(nextX, nextY));
                }
            }
        }

        int safeAreaCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) safeAreaCount++;
            }
        }

        return safeAreaCount;
    }

    public void makeWall(int wallCount) {
        if (wallCount == 3) {
            int[][] copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                copyMap[i] = map[i].clone();
            }

            answer = Math.max(answer, bfs(copyMap));
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    map[i][j] = 1;
                    visited[i][j] = true;
                    makeWall(wallCount + 1);
                    map[i][j] = 0;
                    visited[i][j] = false;
                }
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

        main.makeWall(0);

        System.out.println(answer);
    }
}
