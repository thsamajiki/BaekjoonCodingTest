package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] kits;
    static boolean[] visited;
    static int count = 0;

    public void solution(int sum, int level) {
        if (level == N) {
            count++;
            return;
        }
        else {
            for (int i = 1; i < kits.length; i++) {
                if (!visited[i] && sum + kits[i] - K >= 500) {
                    visited[i] = true;
                    solution(sum + kits[i] - K, level + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 운동 키트의 개수
        K = Integer.parseInt(st.nextToken()); // 하루가 지날 때마다 감소하는 중량

        kits = new int[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        main.solution(500, 0);

        System.out.println(count);
    }
}