package Graph_DFS_BFS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        Main.M = 4;
        Main.N = 5;
        Main.dp = new int[][] {
                { -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1 }
        };

        Main.map = new int[][] {
                { 50, 45, 37, 32, 30 },
                { 35, 50, 40, 20, 25 },
                { 30, 30, 25, 17, 28 },
                { 27, 24, 22, 15, 10 }
        };

        assertEquals(3, main.DFS(0, 0));
    }
}