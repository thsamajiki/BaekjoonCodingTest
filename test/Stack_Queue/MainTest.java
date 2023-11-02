package Stack_Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals("ABC+*", main.solution("A*(B+C)"));
        assertEquals("AB+", main.solution("A+B"));
        assertEquals("ABC*+", main.solution("A+B*C"));
        assertEquals("ABC*+DE/-", main.solution("A+B*C-D/E"));
    }
}