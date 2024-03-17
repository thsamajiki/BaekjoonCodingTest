package Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    static int[][] A, map;
    static ArrayList<Tree> trees;
    static ArrayList<Tree> liveTrees;
    static ArrayList<Tree> deadTrees;

    public void spring() {
        for (int i = 0; i < trees.size(); i++) {
            Tree tree = trees.get(i);

            // 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
            if (tree.age > map[tree.x][tree.y]) {
                deadTrees.add(tree);
            } else {
                map[tree.x][tree.y] -= tree.age;
                tree.age++;
                liveTrees.add(tree);
            }
        }

        trees.clear();
        trees.addAll(liveTrees);
    }

    public void summer() {
        for (int i = 0; i < deadTrees.size(); i++) {
            Tree tree = deadTrees.get(i);
            map[tree.x][tree.y] += tree.age / 2;
        }
    }

    public void autumn() {
        for (int i = 0; i < trees.size(); i++) {
            Tree tree = trees.get(i);

            if (tree.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int nextX = tree.x + dx[j];
                    int nextY = tree.y + dy[j];

                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                    trees.add(new Tree(nextX, nextY, 1));
                }
            }
        }
    }

    public void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += A[i][j];
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

        A = new int[N][N];
        map = new int[N][N]; // 양분
        trees = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x - 1, y - 1, z));
        }

        while (K > 0) {
            // 구분 초기화
            liveTrees = new ArrayList<>();
            deadTrees = new ArrayList<>();
            // 정렬
            Collections.sort(trees);
            main.spring();
            main.summer();
            main.autumn();
            main.winter();
            K--;
        }

        System.out.println(trees.size());
    }
}

