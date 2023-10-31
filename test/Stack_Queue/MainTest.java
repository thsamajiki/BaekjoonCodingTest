package Stack_Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals("mirkovniz", main.solution("mirkovC4nizCC44", "C4"));
        assertEquals("FRULA", main.solution("12ab112ab2ab", "12ab"));
    }
}