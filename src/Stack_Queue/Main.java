package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public int solution(String str) {
        int answer = 0;
        int multiplier = 1;
        Stack<Character> stack = new Stack<>();

        int length = str.length();

        // 분배 법칙을 생각하자!
        // 반례 : ()]()가 있어서 재채점된 문제
        loop:
        for (int i = 0; i < length; i++) {
            switch (str.charAt(i)) {
                case '(':
                    stack.push(str.charAt(i));
                    multiplier *= 2;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        answer = 0;
                        break loop;
                    }

                    if (str.charAt(i - 1) == '(') {
                        answer += multiplier;
                    }
                    stack.pop();
                    multiplier /= 2;
                    break;
                case '[':
                    stack.push(str.charAt(i));
                    multiplier *= 3;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        answer = 0;
                        break loop;
                    }

                    if (str.charAt(i - 1) == '[') {
                        answer += multiplier;
                    }
                    stack.pop();
                    multiplier /= 3;
                    break;
            }

            System.out.println(i + "번째");
            System.out.println("stack : " + stack);
            System.out.println("multiplier : " + multiplier);
            System.out.println("answer : " + answer);
            System.out.println("===========\n");
        }
        
        if (!stack.isEmpty()) {
            answer = 0;
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