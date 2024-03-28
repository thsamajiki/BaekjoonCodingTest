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
    public String solution(int N, int[] topHeights) {
        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // i번째 탑이 쏜 레이저를 수신하는 탑의 수 구하기 (높이가 더 높은 탑만 스택 삽입)
        for (int i = 1; i <= N; i++) {
            // 스택의 탑이 i번째 탑보다 높이가 작으면 삭제
            while (!stack.isEmpty() && stack.peek().height < topHeights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) { // 수신할 탑이 없으면 0 출력
                sb.append("0 ");
            } else { // 수신한 탑이 있으면 탑의 번호 출력
                sb.append(stack.peek().index).append(" ");
            }

            stack.push(new Top(topHeights[i], i)); // i번째 탑을 스택에 일단 삽입
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] topHeights = new int[N + 1]; // 탑 번호를 1 ~ N

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            topHeights[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(N, topHeights));
    }
}
