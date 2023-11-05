package Stack_Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals(8, main.solution(new int[] { 7, 4, 5, 6 }, 2, 10));
        assertEquals(101, main.solution(new int[] { 10 }, 100, 100));
        assertEquals(110, main.solution(new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, 100, 100));
    }
}