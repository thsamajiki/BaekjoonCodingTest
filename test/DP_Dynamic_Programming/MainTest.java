package DP_Dynamic_Programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();

        assertEquals(4, main.solution("ACAYKP", "CAPCAK"));
    }
}
