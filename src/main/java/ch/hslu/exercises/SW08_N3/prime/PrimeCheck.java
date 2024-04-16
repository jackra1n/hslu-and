/*
 * Copyright 2024 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.exercises.SW08_N3.prime;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 100 grosse Primzahlen finden.
 */
public final class PrimeCheck {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeCheck.class);

    /**
     * Privater Konstruktor.
     */
    private PrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) throws InterruptedException {
        int primes_to_find = 100;
        ArrayBlockingQueue<BigInteger> queue = new ArrayBlockingQueue<>(primes_to_find);
        int cpus = Runtime.getRuntime().availableProcessors();
        LOG.info("CPUs: {}", cpus);
        var start = System.currentTimeMillis();
        try (ExecutorService executor = Executors.newFixedThreadPool(cpus)) {
            for (int i = 0; i < primes_to_find; i++) {
                executor.submit(new PrimeTask(queue, primes_to_find));
            }
            executor.shutdown();
            boolean finishedInTime = executor.awaitTermination(20, TimeUnit.SECONDS);
            var end = System.currentTimeMillis();
            if (!finishedInTime) {
                LOG.error("Timeout");
            }
            LOG.info("Found {} primes in {} ms", queue.size(), end - start);
        }
    }
}
