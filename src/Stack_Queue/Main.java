package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    int height;
    int index;

    public Top(int height, int index) {
        this.height = height;
        this.index = index;
    }
}

public class Main {
    public String solution(int n, int[] arr) {
        Stack<Top> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek().height < arr[i]) {
                stack.pop(); // 탑이 신호를 보냈을 때, 받을 수 있는 탑이 나올 때까지 top을 pop한다
            }

            if (stack.isEmpty()) {
                sb.append("0").append(" "); // stack이 비었다면 금방 세워진 탑이 제일 높으므로 0을 출력
            } else {
                sb.append(stack.peek().index).append(" ");
            }

            stack.push(new Top(arr[i], i + 1));
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(N, arr));
    }
}