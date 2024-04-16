package ch.hslu.exercises.SW08_N3.prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class PrimeTask implements Runnable {

    private final BlockingQueue<BigInteger> queue;
    private final int queueMaxSize;

    public PrimeTask(BlockingQueue<BigInteger> queue, int queueMaxSize) {
        this.queue = queue;
        this.queueMaxSize = queueMaxSize;
    }

    @Override
    public void run() {
        while (queue.size() < queueMaxSize) {
            var bi = BigInteger.probablePrime(1024, new Random());
            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                queue.add(bi);
            }
        }


    }



}
