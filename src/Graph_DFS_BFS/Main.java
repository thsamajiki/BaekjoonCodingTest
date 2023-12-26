package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static boolean[] visited;
    static int[] nums;
    static ArrayList<Integer> list;

    private void solution(int start, int target) {
        if (!visited[nums[start]]) {
            visited[nums[start]] = true;
            solution(nums[start], target);
            visited[nums[start]] = false;
        }

        if (nums[start] == target) list.add(target);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        nums = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            main.solution(i, i);
            visited[i] = false;
        }

        Collections.sort(list); // 작은 수 부터 출력하므로 정렬한다.
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}