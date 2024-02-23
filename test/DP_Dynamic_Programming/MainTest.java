package DP_Dynamic_Programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();

        Main.arr = new Consulting[] {
                new Consulting(0, 0),
                new Consulting(3, 10),
                new Consulting(5, 20),
                new Consulting(1, 10),
                new Consulting(1, 20),
                new Consulting(2, 15),
                new Consulting(4, 40),
                new Consulting(2, 200)
        };
        assertEquals(45, main.solution(7));

        Main.arr = new Consulting[] {
                new Consulting(0, 0),
                new Consulting(1, 1),
                new Consulting(1, 2),
                new Consulting(1, 3),
                new Consulting(1, 4),
                new Consulting(1, 5),
                new Consulting(1, 6),
                new Consulting(1, 7),
                new Consulting(1, 8),
                new Consulting(1, 9),
                new Consulting(1, 10)
        };
        assertEquals(55, main.solution(10));

        Main.arr = new Consulting[] {
                new Consulting(0, 0),
                new Consulting(5, 10),
                new Consulting(5, 9),
                new Consulting(5, 8),
                new Consulting(5, 7),
                new Consulting(5, 6),
                new Consulting(5, 10),
                new Consulting(5, 9),
                new Consulting(5, 8),
                new Consulting(5, 7),
                new Consulting(5, 6)
        };
        assertEquals(20, main.solution(10));

        Main.arr = new Consulting[] {
                new Consulting(0, 0),
                new Consulting(5, 50),
                new Consulting(4, 40),
                new Consulting(3, 30),
                new Consulting(2, 20),
                new Consulting(1, 10),
                new Consulting(1, 10),
                new Consulting(2, 20),
                new Consulting(3, 30),
                new Consulting(4, 40),
                new Consulting(5, 50)
        };
        assertEquals(90, main.solution(10));
    }
}
