package ch.hslu.exercises.SW08_N3.prime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class PrimeTask implements Runnable {

    private final Logger LOG = LoggerFactory.getLogger(ch.hslu.exercises.SW08_N3.prime.PrimeTask.class);

    private final BlockingQueue<BigInteger> queue;
    private final int queueMaxSize;

    public PrimeTask(BlockingQueue<BigInteger> queue, int queueMaxSize) {
        this.queue = queue;
        this.queueMaxSize = queueMaxSize;
    }

    @Override
    public void run() {
        while(true) {
            var bi = BigInteger.probablePrime(1024, new Random());
            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                var inserted = queue.offer(bi);
                if (!inserted) {
                    return;
                }
                LOG.info("Inserted number: {}", bi);
            }
        }
//        while(true) {
//            var bi = BigInteger.probablePrime(1024, new Random());
//            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
//                try {
//                    queue.add(bi);
//                } catch (IllegalStateException e) {
//                    return;
//                }
//            }
//        }
//        while (queue.size() < queueMaxSize) {
//            var bi = BigInteger.probablePrime(1024, new Random());
//            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
//                queue.add(bi);
//            }
//        }


    }



}
