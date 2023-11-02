package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public int priority(char operator) {
        if (operator == '(' || operator == ')') return 0;
        else if (operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        return -1;
    }

    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/': // 우선순위가 큰 연산자가 먼저 계산되어야 하므로 현재 연산자의 우선순위보다 큰 연산자가 stack의 맨 위에 있다면 없을 때까지 pop한다.
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')': // (가 나올 때까지 stack 안의 연산자를 pop한다!
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(ch);
                    break;
            }

            System.out.println(i + 1 + "번째");
            System.out.println(str);
            System.out.println("ch : " + ch);
            System.out.println("stack : " + stack);
            System.out.println("sb : " + sb);
            System.out.println("============\n");
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(main.solution(str));
    }
}