package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public String solution(String str) {
        String answer = "";
        // cursor를 기준으로 앞에 있는 문자열은 left Stack에 쌓고 뒤에 있는 문자열은 right Stack에 쌓았다.
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '<':
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case '>':
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case '-':
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                default:
                    left.push(str.charAt(i));
                    break;
            }

            System.out.println(i + "번째");
            System.out.println("left : " + left);
            System.out.println("right : " + right);
            System.out.println("===========\n");
        }



        StringBuilder sb = new StringBuilder();

        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        answer = sb.toString();

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            String str = br.readLine();

            System.out.println(main.solution(str));
        }
    }
}