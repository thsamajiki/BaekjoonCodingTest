package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int bufferSize = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        while (true) {
            int packet = Integer.parseInt(br.readLine());

            if (packet == -1) {
                break;
            }

            if (packet == 0) {
                q.poll();
            } else {
                if (packet > 0 && bufferSize > q.size()) {
                    q.offer(packet);
                }
            }
        }

        if (q.isEmpty()) {
            sb.append("empty");
        } else {
            for (int packet : q) {
                sb.append(packet).append(" ");
            }
        }

        System.out.println(sb);
    }
}