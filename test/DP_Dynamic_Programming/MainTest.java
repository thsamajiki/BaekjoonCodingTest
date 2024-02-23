package DP_Dynamic_Programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();

        Main.n = 8;
        assertEquals(5, main.solution(new int[] { 1, 6, 2, 5, 7, 3, 5, 6 }));

        Main.n = 10;
        assertEquals(10, main.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    }
}
