package ch.hslu.exercises.D1;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class AckermannTest {

    private static final Logger LOG = LoggerFactory.getLogger(AckermannTest.class);

    @Test
    void testAck() {
        var result = Ackermann.ack(2, 2);
        assertThat(result).isEqualTo(7);
        LOG.info(Ackermann.getCount() + " calls");
    }
}
