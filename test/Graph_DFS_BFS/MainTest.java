package Graph_DFS_BFS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        Main.N = 6;
        Main.M = 4;
        Main.visited = new boolean[Main.N + 1][Main.M + 1][2];
        Main.map = new int[][]{
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 1, 1, 1, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1 },
                { 0, 0, 0, 0, 0 }
        };

        assertEquals(15, main.solution(1, 1));

        Main.N = 4;
        Main.M = 4;
        Main.visited = new boolean[Main.N + 1][Main.M + 1][2];
        Main.map = new int[][]{
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 0 }
        };

        assertEquals(-1, main.solution(1, 1));
    }
}