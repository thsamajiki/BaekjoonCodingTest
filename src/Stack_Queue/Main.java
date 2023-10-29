package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public String solution(String str, String[] commands) {
        Stack<Character> originalStack = new Stack<>(); // 기준, peek 지점이 바로 현재 커서의 위치
        Stack<Character> tempStack = new Stack<>(); // 커서 뒤의 원소들을 tempStack으로 이동시켜둔다.

        int N = str.length();
        int M = commands.length;

        for (int i = 0; i < N; i++) {
            originalStack.push(str.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            if (commands[i].length() >= 2) {
                commands[i] = commands[i].replace(" ", "");
            }
            char[] command = commands[i].toCharArray();

            switch (command[0]) {
                case 'L': // 커서를 왼쪽으로 옮겨야 하기 때문에 커서 뒤에 존재하는 원소들을 tempStack으로 옮긴다.
                    if (!originalStack.isEmpty()) {
                        tempStack.push(originalStack.pop());
                    }
                    break;
                case 'D': // 커서를 오른쪽으로 옮겨야 하기 때문에 tempStack에 존재하는 원소들을 originalStack으로 옮긴다.
                    if (!tempStack.isEmpty()) {
                        originalStack.push(tempStack.pop());
                    }
                    break;
                case 'B':
                    if (!originalStack.isEmpty()) {
                        originalStack.pop();
                    }
                    break;
                case 'P':
                    originalStack.push(command[1]);
                    break;
            }
        }

        while (!tempStack.isEmpty()) {
            originalStack.push(tempStack.pop());
        }

        StringBuilder sb = new StringBuilder();

        for (char x : originalStack) {
            sb.append(x);
        }

        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int M = Integer.parseInt(br.readLine());

        String[] commands = new String[M];

        for (int i = 0; i < M; i++) {
            commands[i] = br.readLine();
        }

        System.out.println(main.solution(str, commands));
    }
}