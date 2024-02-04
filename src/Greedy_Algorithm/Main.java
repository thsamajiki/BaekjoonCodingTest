package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public int solution(String[] words) {
        int answer = 0;
        int[] letters = new int[26];

        for(String word: words) {
            int digit = word.length() - 1;

            for(char letter: word.toCharArray()) {
                int index = letter - 'A';

                letters[index] += (int)Math.pow(10, digit);
                digit--;
            }
        }

        Arrays.sort(letters);
        int max = 9;

        for (int i = letters.length - 1; i >= 0; i--) {
            if (max == 0) break;
            answer += letters[i] * max;
            max--;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        System.out.println(main.solution(words));
    }
}
