package ch.hslu.exercises.D1;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTest {

    private static final Logger LOG = LoggerFactory.getLogger(FibonacciTest.class);

    @Test
    void testFiboRec1() {
        var result = Fibonacci.fiboRec1(1);
        assertThat(result).isEqualTo(1);

        result = Fibonacci.fiboRec1(2);
        assertThat(result).isEqualTo(1);

        result = Fibonacci.fiboRec1(3);
        assertThat(result).isEqualTo(2);

    }

    @Test
    void testFiboRec2() {
        var fibo = new Fibonacci();

        var result = fibo.fiboRec2(1);
        assertThat(result).isEqualTo(1);
        fibo.clearMemo();

        result = fibo.fiboRec2(2);
        assertThat(result).isEqualTo(1);
        fibo.clearMemo();

        result = fibo.fiboRec2(10);
        assertThat(result).isEqualTo(55);
        fibo.clearMemo();

        result = fibo.fiboRec2(40);
        assertThat(result).isEqualTo(102334155);
        fibo.clearMemo();
    }

    @Test
    void testFiboIter() {
        var fibo = new Fibonacci();

        var result = fibo.fiboIter(3);
        assertThat(result).isEqualTo(2);

        result = fibo.fiboIter(5);
        assertThat(result).isEqualTo(5);

        result = fibo.fiboIter(7);
        assertThat(result).isEqualTo(13);
    }
}
