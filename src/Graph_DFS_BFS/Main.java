package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, minCost = Integer.MAX_VALUE;
    static int[][] W;
    static boolean[] visited;

    public void solution(int start, int now, int depth, int sum) {
        if (depth == N - 1) { // 모든 도시 방문한 경우
            if (W[now][start] > 0) { // 마지막 도시에서 출발했던 시작 도시로 가는 비용 더하기
                sum += W[now][start];
                minCost = Math.min(minCost, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[now][i] > 0) {
                visited[i] = true;
                solution(start, i, depth + 1, sum + W[now][i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            main.solution(i, i, 0, 0);
        }

        System.out.println(minCost);
    }
}
