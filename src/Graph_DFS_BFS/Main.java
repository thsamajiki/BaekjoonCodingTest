package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int r, c, answer = 1;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static char[][] map;
    static Map<Character, Boolean> lettersChecked;

    private void DFS(int x, int y, int count) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= r || nextY < 0 || nextY >= c) continue;
            if (!lettersChecked.get(map[nextX][nextY])) {
                lettersChecked.put(map[nextX][nextY], true);
                DFS(nextX, nextY, count + 1);
                lettersChecked.put(map[nextX][nextY], false);
            } else {
                answer = Math.max(answer, count);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        lettersChecked = new HashMap<>();

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            lettersChecked.put(ch, false);
        }

        char firstLetter = map[0][0];
        lettersChecked.put(firstLetter, true);

        main.DFS(0, 0, 1);

        System.out.println(answer);
    }
}