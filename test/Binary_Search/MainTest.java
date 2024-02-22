package Binary_Search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();

        Main.N = 4;
        assertEquals(127, main.solution(new int[] { 120, 110, 140, 150 }, 485));

        Main.N = 5;
        assertEquals(100, main.solution(new int[] { 70, 80, 30, 40, 100 }, 450));
    }
}