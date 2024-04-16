package ch.hslu.exercises.SW04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashSetTest{

    @Test
    void testAdd(){
        var hashSet = new HashSet<Integer>();
        hashSet.add(1);
        assertThat(hashSet.contains(1)).isTrue();
    }

    @Test
    void testSize(){
        var hashSet = new HashSet<Integer>();
        assertThat(hashSet.size()).isEqualTo(0);
        hashSet.add(1);
        assertThat(hashSet.size()).isEqualTo(1);
    }

    @Test
    void toStringTest(){
        var hashSet = new HashSet<Integer>();
        hashSet.add(1);
        hashSet.add(2);
        assertThat(hashSet.toString()).isEqualTo("HashSet[1, 2]");
    }

    @Test
    void fillTest(){
        var hashSet = new HashSet<Integer>();
        for (int i = 0; i < 100; i++) {
            hashSet.add(i);
        }
        assertThat(hashSet.size()).isEqualTo(100);
    }
}
