package Stack_Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals("BAPC", main.solution("<<BP<A>>Cd-"));
        assertEquals("ThIsIsS3Cr3t", main.solution("ThIsIsS3Cr3t"));
    }
}