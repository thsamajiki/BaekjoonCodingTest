package Stack_Queue;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals("0 0 2 2 4 ", main.solution(5, new int[] {0, 6, 9, 5, 7, 4}));
    }
}