package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] parents;

    private void DFS(int node) {
        for (int x : graph.get(node)) {
            if (!visited[x]) {
                visited[x] = true;
                DFS(x);
                parents[x] = node;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        parents = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        visited[1] = true;
        main.DFS(1);

        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }
}