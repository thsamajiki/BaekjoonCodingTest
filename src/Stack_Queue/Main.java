package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Point point = (Point) obj;
        return this.x == point.x && this.y == point.y;
    }
}

public class Main {
    static int n;
    static int[][] map;
    static Map<Integer, Character> moveInfoMap;
    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { 1, 0, -1, 0 };

    public int solution() {
        int nowX = 0;
        int nowY = 0;
        int time = 0;
        int direction = 0;
        Queue<Point> q = new LinkedList<>();

        map[nowX][nowY] = 2;
        q.offer(new Point(nowX, nowY));

        while (true) {
            time++;

            int nextX = nowX + dx[direction];
            int nextY = nowY + dy[direction];

            // 범위를 벗어날 때 종료
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                break;
            }

            // 뱀 몸통 만날 때 종료
            // new int[]의 equals를 우리가 직접적으로 오버라이딩할 수 없는게 다르다.
            // 우리가 만든 커스텀 클래스는 equals를 따로 오버라이딩할 수 잇고
            // 이걸로 하면 contains 가 의도한 대로 동작하도록 하는게 가능하다.
            if (q.contains(new Point(nextX, nextY))) {
                break;
            }

            // 사과가 있을 때 없을 때 처리
            if (map[nextX][nextY] == 1) {
                map[nextX][nextY] = 2;
                q.offer(new Point(nextX, nextY)); // 머리가 새롭게 움직인 곳을 q에 넣어준다.
            } else {
                q.offer(new Point(nextX, nextY));
                Point temp = q.poll(); // 꼬리 부분의 데이터는 삭제
                map[temp.x][temp.y] = 0;
            }

            if (moveInfoMap.containsKey(time)) {
                if (moveInfoMap.get(time) == 'D') {
                    direction += 1;
                    if (direction == 4) {
                        direction = 0;
                    }
                } else {
                    direction -= 1;
                    if (direction == -1) {
                        direction = 3;
                    }
                }
            }

            map[nextX][nextY] = 2;

            nowX = nextX;
            nowY = nextY;
        }

        return time;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x - 1][y - 1] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        moveInfoMap = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            moveInfoMap.put(time, direction);
        }

        System.out.println(main.solution());
    }
}