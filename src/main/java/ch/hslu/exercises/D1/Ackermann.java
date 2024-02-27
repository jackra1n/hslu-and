package ch.hslu.exercises.D1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ackermann {

    private static int count = 0;

    public static long ack(long n, long m) {
        count++;
        if (n == 0) {
            return m + 1;
        } else if (m == 0) {
            return ack(n - 1, 1);
        } else {
            return ack(n - 1, ack(n, m - 1));
        }
    }

    public static int getCount() {
        return count;
    }
}

