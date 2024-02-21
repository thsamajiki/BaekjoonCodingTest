package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K ,X;
    static ArrayList<ArrayList<Integer>> map;
    static int[] distances;

    public void BFS() {
        distances[X] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(X);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < map.get(now).size(); i++) {
                int next = map.get(now).get(i);

                if (distances[next] == -1) {
                    distances[next] = distances[now] + 1;
                    q.offer(next);
                }
            }
        }

        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (distances[i] == K) {
                System.out.println(i);
                flag = true;
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        distances = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
            distances[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map.get(A).add(B);
        }

        main.BFS();
    }
}
