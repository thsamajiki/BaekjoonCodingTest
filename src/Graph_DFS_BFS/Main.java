package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Consulting {
    int days;
    int money;

    public Consulting(int days, int money) {
        this.days = days;
        this.money = money;
    }
}

public class Main {
    static int N, answer;
    static Consulting[] arr;

    public void solution(int index, int money) {
        if (index >= N + 1) {
            answer = Math.max(answer, money);
            return;
        }

        // N이 7이면 8일에 퇴사를 한다.
        // 5일에 3일 걸리는 상담을 하기 시작하면 5, 6, 7일로 상담을 한다.
        if (index + arr[index].days - 1 <= N) {
            solution(index + arr[index].days, money + arr[index].money);
        } else {
            solution(index + arr[index].days, money);
        }

        solution(index + 1, money); // 현재 일을 선택하지 않을 경우, 이익은 그대로 둔 채 다음날로 넘어감
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new Consulting[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            arr[i] = new Consulting(days, money);
        }

        main.solution(1, 0);

        System.out.println(answer);
    }
}
