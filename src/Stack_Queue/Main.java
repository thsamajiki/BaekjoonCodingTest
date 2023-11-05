package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public int solution(int[] weights, int bridgeLength, int bridgeWeightLimit) {
        int answer = 0;

        int bridgeWeightSum = 0;
        Queue<Integer> bridges = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();

        for (int i = 0; i < bridgeLength; i++) {
            bridges.offer(0);
        }

        for (int i = 0; i < weights.length; i++) {
            trucks.offer(weights[i]);
        }

        while (!bridges.isEmpty()) { // 더이상 넣을 트럭이 없을 때까지 반복 (반복 1번에 시간 + 1)
            answer++;
            bridgeWeightSum -= bridges.poll(); // 다리 무게에서 내려온 트럭 무게를 뺌

            if (!trucks.isEmpty()) {
                if (trucks.peek() + bridgeWeightSum <= bridgeWeightLimit) { // 앞의 트럭의 무게를 더해도 다리의 최대 하중보다 작다면
                    bridgeWeightSum += trucks.peek();
                    bridges.offer(trucks.poll()); // 다리에 트럭 추가
                } else { // 다리의 최대 하중을 초과하면
                    bridges.offer(0); // 다리 위에 트럭을 추가하지 않음
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

        int[] truckWeights = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truckWeights[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(truckWeights, w, L));
    }
}