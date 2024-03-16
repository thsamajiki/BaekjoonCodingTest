package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class AbsNumber implements Comparable<AbsNumber> {
    int num;

    public AbsNumber(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(AbsNumber o2) {
        if (Math.abs(this.num) > Math.abs(o2.num)) {
            return Math.abs(this.num) - Math.abs(o2.num);
        } else if (Math.abs(this.num) == Math.abs(o2.num)) {
            return this.num - o2.num;
        } else {
            return -1; // 무조건 -1을 주어야 하는 것이 아니고 음수이면 가능
        }
    }
}

public class Main {
    public String solution(int[] arr) {
        PriorityQueue<AbsNumber> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int num: arr) {
            if (num != 0) {
                pq.offer(new AbsNumber(num));
            } else {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll().num).append("\n");
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
        }

        System.out.println(main.solution(arr));
    }
}
