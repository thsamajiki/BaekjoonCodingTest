package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    * 재귀탐색을 하게되면 기본적으로 '열'은 서로 다른 위치이니
    * 우리가 검사할 것은 다른 퀸과 동일한 '행'에 위치하는지와 대각선상에 위치하는지를 검사하면 된다.
    * 만약 해당 위치가 공격받지 않는 위치라면 다음 재귀를 호출하고, 아닐 경우는 다음 반복문으로 넘어간다.
    */
    static int N, count = 0;
    static int[] arr; // 각 원소의 index를 '열'이라 생각하고, 원소 값을 '행'이라 생각하기

    public void solution(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            boolean isPossible = true;

            // 놓을 수 있는 위치일 경우 재귀호출
            for (int j = 0; j < depth; j++) {
                // 1. 같은 행에 존재할 경우
                // 2. 대각선상에 놓여있는 경우
                if (arr[depth] == arr[j] || Math.abs(depth - j) == Math.abs(arr[depth] - arr[j])) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                solution(depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        main.solution(0);

        System.out.println(count);
    }
}
