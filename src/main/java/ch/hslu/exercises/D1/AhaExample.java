package ch.hslu.exercises.D1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AhaExample {

    private static final Logger LOG = LoggerFactory.getLogger(AhaExample.class);
    private static final int sleepTimeMs = 1;

    private static int task1Counter = 0;
    private static int task2Counter = 0;
    private static int task3Counter = 0;

    public static void task(final int n) throws InterruptedException {
        task1(); task1(); task1(); task1(); // T ~ 4
        for (int i = 0; i < n; i++) {       // äussere Schleife: n-mal
            task2(); task2(); task2();      // T ~ n · 3
            for (int j = 0; j < n; j++) {   // innerer Schleife: n-mal
                task3(); task3();           // T ~ n · n· 2
            }
        }
        LOG.info("T1: " + task1Counter + ", T2: " + task2Counter + ", T3: " + task3Counter);
        LOG.info("Total time: " + task1Counter * sleepTimeMs + "ms, " + task2Counter * sleepTimeMs + "ms, " + task3Counter * sleepTimeMs + "ms");
        cleanCounters();
    }

    private static void cleanCounters() {
        task1Counter = 0;
        task2Counter = 0;
        task3Counter = 0;
    }

    private static void task1() throws InterruptedException {
        task1Counter++;
        Thread.sleep(sleepTimeMs);
    }

    private static void task2() throws InterruptedException {
        task2Counter++;
        Thread.sleep(sleepTimeMs);
    }

    private static void task3() throws InterruptedException {
        task3Counter++;
        Thread.sleep(sleepTimeMs);
    }

}
