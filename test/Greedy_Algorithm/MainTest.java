package Greedy_Algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();

        assertEquals(4, main.solution(18));
        assertEquals(-1, main.solution(4));
        assertEquals(2, main.solution(6));
        assertEquals(3, main.solution(9));
        assertEquals(3, main.solution(11));
    }
}