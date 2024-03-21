package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Tree implements Comparable<Tree> {
    int x;
    int y;
    int age;

    public Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }

    @Override
    public int compareTo(Tree o) {
        return this.age - o.age;
    }
}

public class Main {
    static int N, M, K;
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[][] A, nutrientMap;
    static PriorityQueue<Tree> liveTrees;
    static ArrayList<Tree> deadTrees;

    public void spring() {
        PriorityQueue<Tree> cloneTrees = new PriorityQueue<>();

        while(!liveTrees.isEmpty()) {
            Tree nowTree = liveTrees.poll();
            int x = nowTree.x;
            int y = nowTree.y;

            if (nutrientMap[x][y] >= nowTree.age) {
                cloneTrees.offer(new Tree(x, y, nowTree.age + 1));
                nutrientMap[x][y] -= nowTree.age;
            } else {
                deadTrees.add(nowTree);
            }
        }

        liveTrees = new PriorityQueue<>(cloneTrees);
    }

    public void summer() {
        for(Tree tree: deadTrees) {
            int x = tree.x;
            int y = tree.y;
            nutrientMap[x][y] += tree.age / 2;
        }
    }

    public void autumn() {
        PriorityQueue<Tree> tempTrees = new PriorityQueue<>();
        while (!liveTrees.isEmpty()) {
            Tree nowTree = liveTrees.poll();
            tempTrees.offer(nowTree);

            if (nowTree.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nextX = nowTree.x + dx[i];
                    int nextY = nowTree.y + dy[i];

                    if (nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > N - 1) continue;

                    tempTrees.offer(new Tree(nextX, nextY, 1));
                }
            }
        }

        liveTrees = new PriorityQueue<>(tempTrees);
    }

    public void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrientMap[i][j] += A[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 땅의 가로, 세로 크기
        M = Integer.parseInt(st.nextToken()); // 심은 나무의 개수
        K = Integer.parseInt(st.nextToken()); // 시간(년)이 얼마나 지났는지

        A = new int[N][N]; // 각 칸에 추가되는 양분의 양
        nutrientMap = new int[N][N]; // 각 칸에 이미 있는 양분의 양

        liveTrees = new PriorityQueue<>();
        deadTrees = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                nutrientMap[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            liveTrees.add(new Tree(x - 1, y - 1, z));
        }

        while (K --> 0) {
            deadTrees = new ArrayList<>();
            main.spring();
            main.summer();
            main.autumn();
            main.winter();
        }

        System.out.println(liveTrees.size());
    }
}
