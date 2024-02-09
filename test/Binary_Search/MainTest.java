package Binary_Search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        Main.N = 4;
        Main.M = 7;
        assertEquals(15, main.solution(new long[] { 20, 15, 10, 17 }));
        Main.N = 5;
        Main.M = 20;
        assertEquals(36, main.solution(new long[] { 4, 42, 40, 26, 46 }));
    }
}