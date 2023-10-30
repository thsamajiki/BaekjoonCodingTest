package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int N, int[] arr) {
        int[] answer = new int[N + 1];
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            /*
             * 스택이 비어 있지 않으면서
             * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
             * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
             * 해당 인덱스의 값을 현재 원소로 바꿔준다.
             */
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        answer = arr;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = main.solution(N, arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}