package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(int N) {
        int answer = -1;

        int fiveCount = N / 5;
        int threeCount = 0;

        while (fiveCount >= 0) {
            int remainingWeight = N - fiveCount * 5;

            if ((remainingWeight) % 3 == 0) {
                threeCount = remainingWeight / 3;
                answer = fiveCount + threeCount;
                break;
            }

            fiveCount--;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(main.solution(N));
    }
}
