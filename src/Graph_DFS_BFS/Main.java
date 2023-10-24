package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    static List<Character> list = new ArrayList<>();

    private String solution(int[] arr, int n) {
        String answer = "NO";
        Stack<Integer> stack = new Stack<>();

        int index = 1;

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            list.add('+');
            while (!stack.isEmpty() && stack.peek() == arr[index]) {
                stack.pop();
                list.add('-');
                index++;
            }
        }

        if (stack.isEmpty()) {
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        String str = main.solution(numbers, n);

        if (str.equals("NO")) {
            System.out.println(str);
        } else {
            for (char ch : list) {
                System.out.println(ch);
            }
        }
    }
}