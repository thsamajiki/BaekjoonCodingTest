package Greedy_Algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();

        assertEquals(-35, main.solution("55-50+40"));
        assertEquals(100, main.solution("10+20+30+40"));
        assertEquals(0, main.solution("00009-00009"));
    }
}