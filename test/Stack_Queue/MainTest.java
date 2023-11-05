package Stack_Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals("<3, 6, 2, 7, 5, 1, 4>", main.solution(7, 3));
    }
}