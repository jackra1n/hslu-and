package ch.hslu.exercises.D1;

import org.junit.jupiter.api.Test;

public class AhaExampleTest {

    @Test
    void testTask() throws InterruptedException {
        AhaExample.task(10);
        AhaExample.task(20);
        AhaExample.task(10);
    }
}
