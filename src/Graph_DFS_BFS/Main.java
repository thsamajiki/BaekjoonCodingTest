package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, answer = 1;
    static int[] dx = { -1, 0, 1,  0 };
    static int[] dy = {  0, 1, 0, -1 };
    static char[][] board;
    static boolean[] visited;

    public void solution(int x, int y, int count) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX > R - 1 || nextY < 0 || nextY > C - 1) continue;
            if (!visited[board[nextX][nextY] - 'A']) {
                visited[board[nextX][nextY] - 'A'] = true;
                solution(nextX, nextY, count + 1);
                visited[board[nextX][nextY] - 'A'] = false;
            } else {
                answer = Math.max(answer, count);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        main.solution(0, 0, 1);

        System.out.println(answer);
    }
}
