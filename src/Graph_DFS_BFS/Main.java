package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, tc, diagonalWaterCount, answer;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
    static ArrayList<Point> savedCloudsXY;

    public void cloudMoves(int d, int s) {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < savedCloudsXY.size(); j++) {
                savedCloudsXY.set(j, new Point((savedCloudsXY.get(j).x + dx[d] + N) % N, (savedCloudsXY.get(j).y + dy[d] + N) % N));
            }
        }

        // 구름이 있는 칸에 비가 1씩 내리고,
        for (int j = 0; j < savedCloudsXY.size(); j++) {
            int x = savedCloudsXY.get(j).x;
            int y = savedCloudsXY.get(j).y;

            A[x][y]++;
        }

        for (int j = 0; j < savedCloudsXY.size(); j++) {
            diagonalWaterCount = 0;
            checkDiagonalWater(savedCloudsXY.get(j).x, savedCloudsXY.get(j).y);
        }
    }

    public void checkDiagonalWater(int x, int y) {
        for (int d = 2; d <= 8; d += 2) {
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if (nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > N - 1) continue;

            if (A[nextX][nextY] != 0) {
                diagonalWaterCount++;
            }

        }
        visited[x][y] = true;
        A[x][y] += diagonalWaterCount;
    }

    public void createClouds() {
        savedCloudsXY = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] >= 2 && !visited[i][j]) {
                    savedCloudsXY.add(new Point(i, j));
                    A[i][j] -= 2;
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

        A = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        savedCloudsXY = new ArrayList<>();
        savedCloudsXY.add(new Point(N - 2, 0));
        savedCloudsXY.add(new Point(N - 2, 1));
        savedCloudsXY.add(new Point(N - 1, 0));
        savedCloudsXY.add(new Point(N - 1, 1));

        for (tc = 0; tc < M; tc++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            main.cloudMoves(d, s);
            main.createClouds();
            visited = new boolean[N][N];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += A[i][j];
            }
        }

        System.out.println(answer);
    }
}
