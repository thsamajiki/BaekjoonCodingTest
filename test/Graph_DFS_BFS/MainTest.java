package Graph_DFS_BFS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals("-1\n" +
                "1\n" +
                "0\n" +
                "-1\n" +
                "-1\n" +
                "1\n" +
                "1\n" +
                "-2\n" +
                "2\n" +
                "0\n", main.solution(new int[] {1,
                -1,
                0,
                0,
                0,
                1,
                1,
                -1,
                -1,
                2,
                -2,
                0,
                0,
                0,
                0,
                0,
                0,
                0}));
    }
}