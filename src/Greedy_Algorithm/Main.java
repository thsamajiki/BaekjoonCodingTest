package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(String str) {
        int answer = Integer.MAX_VALUE;

        String[] subtraction = str.split("-");

        for (int i = 0; i < subtraction.length; i++) {
            int temp = 0;

            String[] addition = subtraction[i].split("[+]");

            for (int j = 0; j < addition.length; j++) {
                temp += Integer.parseInt(addition[j]);
            }

            if (answer == Integer.MAX_VALUE) {
                answer = temp;
            } else {
                answer -= temp;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(main.solution(str));
    }
}
