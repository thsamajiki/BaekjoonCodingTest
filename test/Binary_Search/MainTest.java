package Binary_Search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        Main.N = 5;
        Main.solutions = new int[] { -99, -2, -1, 4, 98 };
        assertArrayEquals(new int[] { -99, 98 }, main.solution(5));
        Main.N = 4;
        Main.solutions = new int[] { -100, -2, -1, 103 };
        assertArrayEquals(new int[] { -100, 103 }, main.solution(4));
    }
}