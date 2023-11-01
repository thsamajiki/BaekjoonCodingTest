package Stack_Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals(28, main.solution("(()[[]])([])"));
        assertEquals(0, main.solution("[][]((])"));
    }
}