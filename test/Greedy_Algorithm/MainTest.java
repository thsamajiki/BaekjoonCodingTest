package Greedy_Algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void solution() {
        Main main = new Main();
        assertEquals(4, main.solution(new Person[] {
                new Person(3, 2),
                new Person(1, 4),
                new Person(4, 1),
                new Person(2, 3),
                new Person(5, 5) }));

        assertEquals(3, main.solution(new Person[] {
                new Person(3, 6),
                new Person(7, 3),
                new Person(4, 2),
                new Person(1, 4),
                new Person(5, 7),
                new Person(2, 5),
                new Person(6, 1)}));
    }
}