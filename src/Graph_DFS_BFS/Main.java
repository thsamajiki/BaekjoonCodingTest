package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private String solution(String str) {
        String answer;
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == ')') {
                if (stack.isEmpty()) {
                    stack.push(ch);
                    answer = "NO";
                    return answer;
                } else {
                    stack.pop(); // 여는 괄호 제거
                }
            } else {
                stack.push(ch);
            }
        }

        if (stack.isEmpty()) {
            answer = "YES";
        } else {
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int td = 0; td < t; td++) {
            String testData = br.readLine();

            System.out.println(main.solution(testData));
        }
    }
}