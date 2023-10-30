package Stack_Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertArrayEquals(new int[] { 5, 7, 7, -1 }, main.solution(3, new int[] { 3, 5, 2, 7 }));
        assertArrayEquals(new int[] { -1, 8, 8, -1 }, main.solution(3, new int[] { 9, 5, 4, 8 }));
    }
}