package DP_Dynamic_Programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        Main.n = 6;
        Main.stairs = new int[] { 0, 10,
                20,
                15,
                25,
                10,
                20 };
        assertEquals(75, main.solution(Main.stairs));
    }
}