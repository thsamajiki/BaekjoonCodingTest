package Stack_Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals("abcdyx", main.solution("abcd", new String[] { "P x", "L", "P y" }));
        assertEquals("yxabc", main.solution("abc", new String[] { "L", "L", "L", "L", "L", "P x", "L", "B", "P y" }));
        assertEquals("yxz", main.solution("dmih", new String[] { "B", "B", "P x", "L", "B", "B", "B", "P y", "D", "D", "P z" }));
    }
}