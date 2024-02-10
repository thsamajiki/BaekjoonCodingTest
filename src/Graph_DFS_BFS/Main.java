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
    static int M, N, answer;
    static int[] dx = { -1, 0, 1,  0 };
    static int[] dy = {  0, 1, 0, -1 };
    static Queue<Point> q = new LinkedList<>();
    static int[][] map;
    static boolean[][] visited;
    static int[][] days;

    public void BFS() {
        while (!q.isEmpty()) {
            Point now = q.poll();
            int nowX = now.x;
            int nowY = now.y;

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = 1;
                    q.offer(new Point(nextX, nextY));
                    days[nextX][nextY] = days[nowX][nowY] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        days = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean allRipen = true;
        loop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || map[i][j] == -1) {
                    allRipen = false;
                    break loop;
                }
            }
        }

        if (allRipen) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    q.offer(new Point(i, j));
                    days[i][j] = 0;

                } else {
                    days[i][j] = -1;
                }
            }
        }

        main.BFS();

        boolean notAllRipen = true;
        loop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && days[i][j] == -1) {
                    notAllRipen = false;
                    break loop;
                }
            }
        }

        if (!notAllRipen) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer = Math.max(answer, days[i][j]);
            }
        }

        System.out.println(answer);
    }
}
