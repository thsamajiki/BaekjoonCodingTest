package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;
    int distance;
    boolean destroyedWall;

    public Point(int x, int y, int distance, boolean destroyedWall) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.destroyedWall = destroyedWall;
    }
}

public class Main {
    static int N, M, answer = Integer.MAX_VALUE;
    static int[] dx = { -1, 0, 1,  0 };
    static int[] dy = {  0, 1, 0, -1 };
    static int[][] map;
    static boolean[][][] visited;

    public int solution(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 1, false));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == N && now.y == M) {
                answer = now.distance;
                return answer;
            } else {
                for (int i = 0; i < 4; i++) {
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];
                    int nextDistance = now.distance + 1;

                    if (nextX < 1 || nextX > N || nextY < 1 || nextY > M) continue;

                    if (now.destroyedWall) { // 벽을 부순 적이 있을 때
                        // 해당 지점이 벽이 아니고 방문한 적이 없다면 큐에 정보를 넣는다.
                        if (map[nextX][nextY] == 0 && !visited[nextX][nextY][1]) {
                            visited[nextX][nextY][1] = true;
                            q.offer(new Point(nextX, nextY, nextDistance, true));
                        }
                        // 한번 부순 적이 있다면 또 부수고 갈 수 없기 때문에 pass
                    } else { // 벽을 부순 적이 없을 때
                        if (map[nextX][nextY] == 1) { // 벽이라면 벽을 부수고 큐에 값을 넣는다.
                            visited[nextX][nextY][1] = true;
                            q.offer(new Point(nextX, nextY, nextDistance, true));
                        } else if (!visited[nextX][nextY][0]){ // 벽이 아니고 방문한 적이 없다면 큐에 값을 넣는다.
                            visited[nextX][nextY][0] = true;
                            q.offer(new Point(nextX, nextY, nextDistance, false));
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String row = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }

        visited = new boolean[N + 1][M + 1][2];

        visited[1][1][0] = true;
        System.out.println(main.solution(1, 1));
    }
}
