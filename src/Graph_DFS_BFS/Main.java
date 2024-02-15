package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static int[] buttonCounts;

    public void bfs(int f, int s, int g, int u, int d) {
        Queue<Integer> q = new LinkedList<>();
        buttonCounts[s] = 0;
        q.offer(s);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == g) {
                System.out.println(buttonCounts[now]);
                return;
            }

            if (u > 0 && now + u <= f && buttonCounts[now + u] == 0) { // 현재 위치 + 위로 <= 최고층 && 방문 안했으면
                buttonCounts[now + u] = buttonCounts[now] + 1;
                q.offer(now + u);
            }

            if (d > 0 && now - d >= 1 && buttonCounts[now - d] == 0) { // 현재 위치 - 아래로 >= 1 && 방문 안했으면
                buttonCounts[now - d] = buttonCounts[now] + 1;
                q.offer(now - d);
            }
        }

        if (buttonCounts[g] == 0) {
            System.out.println("use the stairs");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        buttonCounts = new int[F + 1];

        main.bfs(F, S, G, U, D);
    }
}
