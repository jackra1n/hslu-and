package ch.hslu.exercises.D1;

import org.junit.jupiter.api.Test;

public class AhaExampleTest {

    @Test
    void testTask() throws InterruptedException {
        AhaExample.task(2);
        AhaExample.task(5);
        AhaExample.task(10);
    }
}
