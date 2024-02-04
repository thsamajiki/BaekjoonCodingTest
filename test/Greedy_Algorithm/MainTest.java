package Greedy_Algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();

        assertEquals(1998, main.solution(new String[]{"AAA", "AAA"}));
        assertEquals(99437, main.solution(new String[]{"GCF", "ACDEB"}));
        assertEquals(45, main.solution(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}));
        assertEquals(187, main.solution(new String[]{"AB", "BA"}));
    }
}