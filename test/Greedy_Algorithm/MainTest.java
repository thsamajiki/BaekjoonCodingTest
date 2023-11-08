package Greedy_Algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals(32, main.solution(new int[] { 3, 1, 4, 3, 2 }));
    }
}