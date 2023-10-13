package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, totalCount, houseCount;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] graph;
    static boolean[][] visited;

    private void DFS(int x, int y) {
        houseCount++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX > n - 1 || nextY < 0 || nextY > n - 1 ) continue;
            if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                graph[nextX][nextY] = totalCount;
                DFS(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                int num = Character.getNumericValue(temp.charAt(j));
                graph[i][j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    houseCount = 0;
                    totalCount++;
                    visited[i][j] = true;
                    graph[i][j] = totalCount;
                    main.DFS(i, j);
                    list.add(houseCount);
                }
                houseCount = 0;
            }
        }

        System.out.println(totalCount);

        Collections.sort(list);

        for (int count : list) {
            System.out.println(count);
        }
    }
}