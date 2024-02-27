package ch.hslu.exercises.D1;

import org.junit.jupiter.api.Test;

public class NextSymmetricNumberTest {

    @Test
    void nextNumberEasy() {
        var start = System.currentTimeMillis();
        int number = 193; // Example number
        int nextSymmetricNumber = NextSymmetricNumber.findNextSymmetricNumber(number);
        var end = System.currentTimeMillis();
        System.out.println("The next symmetric number is: " + nextSymmetricNumber);
        System.out.println("Time: " + (end - start) + "ms");

    }

    @Test
    void nextNumberHard() {
        var start = System.currentTimeMillis();
        int number = 14738717; // Example number
        int nextSymmetricNumber = NextSymmetricNumber.findNextSymmetricNumber(number);
        var end = System.currentTimeMillis();
        System.out.println("The next symmetric number is: " + nextSymmetricNumber);
        System.out.println("Time: " + (end - start) + "ms");
    }
}
