package ch.hslu.demo;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AllocationTest {

    @Test
    void testAllocationEquals() {
        final Allocation block1 = new Allocation(new byte[1024], 0, 16);
        final Allocation block2 = new Allocation(new byte[1024], 16, 8);
        assertThat(block1).isNotEqualTo(block2);
    }

    @Test
    void testAllocationToString() {
        final Allocation block1 = new Allocation(new byte[1024], 0, 16);
        assertThat(block1.toString()).isEqualTo("Allocation[Address: 0, Size: 16]");
    }

    @Test
    void equalsVerifier() {
        EqualsVerifier.forClass(Allocation.class).verify();
    }
}
