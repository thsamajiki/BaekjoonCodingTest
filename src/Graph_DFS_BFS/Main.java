package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dice {
    int front;
    int back;
    int up;
    int down;
    int left;
    int right;

    public Dice() {
        this.front = 0;
        this.back = 0;
        this.up = 0;
        this.down = 0;
        this.left = 0;
        this.right = 0;
    }

    public void moveNorth() {
        int tmp = this.front;
        this.front = this.up;
        this.up = this.back;
        this.back = this.down;
        this.down = tmp;
    }

    public void moveSouth() {
        int tmp = this.down;
        this.down = this.back;
        this.back = this.up;
        this.up = this.front;
        this.front = tmp;
    }

    public void moveEast() {
        int tmp = this.down;
        this.down = this.right;
        this.right = this.up;
        this.up = this.left;
        this.left = tmp;
    }

    public void moveWest() {
        int tmp = this.down;
        this.down = this.left;
        this.left = this.up;
        this.up = this.right;
        this.right = tmp;
    }

    public void copyToDice(int req) {
        this.down = req;
    }

    public void copyToMap(int[][] req, int y, int x) {
        req[y][x] = this.down;
    }
}

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static Queue<Integer> commands;
    static Dice dice;

    public int solution(int command) {
        switch (command) {
            case 1: // 동쪽
                if (x + 1 < M) {
                    dice.moveEast();
                    x++;

                    if (map[y][x] == 0) {
                        dice.copyToMap(map, y, x);
                    } else {
                        dice.copyToDice(map[y][x]);
                        map[y][x] = 0;
                    }

                    return dice.up;
                }
                break;
            case 2: // 서쪽
                if (x - 1 >= 0) {
                    dice.moveWest();
                    x--;

                    if (map[y][x] == 0) {
                        dice.copyToMap(map, y, x);
                    } else {
                        dice.copyToDice(map[y][x]);
                        map[y][x] = 0;
                    }

                    return dice.up;
                }
                break;
            case 3: // 북쪽
                if (y - 1 >= 0) {
                    dice.moveNorth();
                    y--;

                    if (map[y][x] == 0) {
                        dice.copyToMap(map, y, x);
                    } else {
                        dice.copyToDice(map[y][x]);
                        map[y][x] = 0;
                    }

                    return dice.up;
                }
                break;
            case 4: // 남쪽
                if (y + 1 < N) {
                    dice.moveSouth();
                    y++;

                    if (map[y][x] == 0) {
                        dice.copyToMap(map, y, x);
                    } else {
                        dice.copyToDice(map[y][x]);
                        map[y][x] = 0;
                    }

                    return dice.up;
                }
                break;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[21][21];
        commands = new LinkedList<>();
        dice = new Dice();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            commands.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        while (!commands.isEmpty()) {
            int command = commands.poll();
            int top = main.solution(command);
            if (top != -1) {
                sb.append(top);
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}