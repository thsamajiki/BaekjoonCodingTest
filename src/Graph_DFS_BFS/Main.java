package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static char[][] map;
    static boolean[][] visited;

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        char color = map[x][y];

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if (checkOutOfRange(nextX, nextY)) continue;
                if (!visited[nextX][nextY] && map[nextX][nextY] == color) {
                    visited[nextX][nextY] = true;
                    q.offer(new Point(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        int normal = 0;
        int abnormal = 0;

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 정상인
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    normal++;
                    bfs(i, j);
                }
            }
        }

        visited = new boolean[N][N];

        // 적록색약에 대한 map 세팅
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        // 적록색약
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    abnormal++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(normal + " " + abnormal);
    }

    private static boolean checkOutOfRange(int x, int y) {
        return x < 0 || x > N - 1 || y < 0 || y > N - 1;
    }
}