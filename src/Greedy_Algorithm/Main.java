package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(int n) {
        int answer = -1;

        int weightPerFive = n / 5;
        int weightPerThree = 0;

        while (weightPerFive >= 0) {
            int remainingWeight = n - weightPerFive * 5;

            if (remainingWeight % 3 == 0) {
                weightPerThree = remainingWeight / 3;
                answer = weightPerFive + weightPerThree;
                break;
            }

            weightPerFive--;
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
