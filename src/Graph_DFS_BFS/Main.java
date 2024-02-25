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
    static int N, houseCount = 0, areaCount = 1;
    static ArrayList<Integer> list;
    static int[] dx = { -1, 0, 1,  0 };
    static int[] dy = {  0, 1, 0, -1 };
    static int[][] map;
    static boolean[][] visited;

    public void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        map[x][y] = areaCount;
        houseCount = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > N - 1) continue;
                if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = areaCount;
                    houseCount++;
                    q.offer(new Point(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    main.BFS(i, j);
                    list.add(houseCount);
                    areaCount++;
                }
            }
        }

        System.out.println(areaCount - 1);

        Collections.sort(list);
        
        for(int houseCount: list) {
            System.out.println(houseCount);
        }
    }
}
