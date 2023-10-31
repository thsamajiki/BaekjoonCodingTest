package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public String solution(String str, String bomb) {
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int strLength = str.length();
        int bombLength = bomb.length();


        for (int i = 0; i < strLength; i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= bombLength) {
                boolean isSame = true;

                System.out.println("stack : " + stack);
                System.out.println("stack.size() : " + stack.size());
                System.out.println("bombLength : " + bombLength);

                for (int j = 0; j < bombLength; j++) {
                    System.out.println("stack의 크기 (= " + stack.size() + ") - bombLength (= " + bombLength + ") + j(= " + j + ") : " + stack.get(stack.size() - bombLength + j));
                    System.out.println("bomb.charAt(" + j + ") : " + bomb.charAt(j));
                    System.out.println(stack.get(stack.size() - bombLength + j) != bomb.charAt(j));
                    if (stack.get(stack.size() - bombLength + j) != bomb.charAt(j)) {
                        isSame = false;
                        System.out.println("isSame : " + isSame);
                        break;
                    }
                }

                if (isSame) {
                    System.out.println("isSame이 true일 때 진입");
                    for (int j = 0; j < bombLength; j++) {
                        stack.pop();
                    }
                }
            }
        }

        for (char ch : stack) {
            sb.append(ch);
        }

        if (sb.length() == 0) {
            sb.append("FRULA");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        System.out.println(main.solution(str, bomb));
    }
}