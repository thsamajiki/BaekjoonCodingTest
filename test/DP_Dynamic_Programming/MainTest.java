package DP_Dynamic_Programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals(96, main.solution(new int[][] { { 0, 0, 0 }, { 26, 40, 83 }, { 49, 60, 57 }, { 13, 89, 99 } }));
        assertEquals(3, main.solution(new int[][] { { 0, 0, 0 }, { 1, 100, 100 }, { 100, 1, 100 }, { 100, 100, 1 } }));
        assertEquals(102, main.solution(new int[][] { { 0, 0, 0 }, { 1, 100, 100 }, { 100, 100, 100 }, { 1, 100, 100 } }));
        assertEquals(208, main.solution(new int[][] { { 0, 0, 0 }, { 30, 19, 5 }, { 64, 77, 64 }, { 15, 19, 97 }, { 4, 71, 57 }, { 90, 86, 84 }, { 93, 32, 91 } }));
        assertEquals(253, main.solution(new int[][] { { 0, 0, 0 }, { 71, 39, 44 }, { 32, 83, 55 }, { 51, 37, 63 }, { 89, 29, 100 }, { 83, 58, 11 }, { 65, 13, 15 }, { 47, 25, 29 }, { 60, 66, 19 } }));
    }
}