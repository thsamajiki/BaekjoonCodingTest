package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] solutions;

    public int[] solution(int N) {
        int[] answer = new int[2];
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) { // solutions[i] 값에 대하여 나머지 하나의 용액 선택
            int left = i + 1; // 현재 용액 다음 ~ 끝까지 이분탐색
            int right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                int sum = solutions[i] + solutions[mid];

                if (Math.abs(sum) < diff) {
                    answer[0] = solutions[i];
                    answer[1] = solutions[mid];
                    diff = Math.abs(sum);
                }

                if (sum < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 전체 용액의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        solutions = new int[N]; // 용액의 특성값 배열
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = main.solution(N);
        
        for(int num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
