package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, R, Q;
    static ArrayList<Integer>[] tree; // 인접 리스트로 간선의 정보를 저장
    static int[] subTree; // 각 노드의 서브트리
    static boolean[] visited;

    public int solution(int root) {
        int count = 1;
        for(int node: tree[root]) {
            if (!visited[node]) {
                visited[node] = true;
                count += solution(node); // 자식노드의 개수를 더해준다.
            }
        }

        return subTree[root] = count;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        subTree = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());;
            int to = Integer.parseInt(st.nextToken());;
            tree[from].add(to);
            tree[to].add(from);
        }

        visited[R] = true;
        main.solution(R);

        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            System.out.println(subTree[U]);
        }
    }
}