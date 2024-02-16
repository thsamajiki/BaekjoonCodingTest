package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[] dx = { -1, -1, 0,  1, 1,  1,  0, -1 };
    static int[] dy = {  0,  1, 1,  1, 0, -1, -1, -1 };
    static int[][] map;
    static boolean[][] visited;

    public void solution(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX > h - 1 || nextY < 0 || nextY > w - 1) continue;

            if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                solution(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        answer++;
                        visited[i][j] = true;
                        main.solution(i, j);
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
