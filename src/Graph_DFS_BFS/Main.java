package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k;
    static int[] nums;
    static int[] S;

    public void solution(int start, int L) {
        if (L == 6) {
            for(int num: nums) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = start; i < k; i++) {
                nums[L] = S[i];
                solution(i + 1, L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            nums = new int[6];

            main.solution(0, 0);

            System.out.println();
        }
    }
}
