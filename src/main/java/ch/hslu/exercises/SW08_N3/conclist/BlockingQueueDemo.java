/*
 * Copyright 2024 Hochschule Luzern - Informatik.
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
package ch.hslu.exercises.SW08_N3.conclist;

import java.util.*;
import java.util.concurrent.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public final class BlockingQueueDemo {

    private static final Logger LOG = LoggerFactory.getLogger(ch.hslu.exercises.SW08_N3.conclist.DemoConcurrentList.class);


    public static void main(final String args[]) throws InterruptedException, ExecutionException {
        // example with BlockingQueue
        ArrayBlockingQueue<Integer> list = new ArrayBlockingQueue<>(10_000_000);

        final List<Future<Long>> futures = new ArrayList<>();
        var start = System.currentTimeMillis();
        try (final ExecutorService executor = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 3; i++) {
                futures.add(executor.submit(new BlockingProducer(list, 1_000_000)));
            }
            Iterator<Future<Long>> iterator = futures.iterator();
            long totProd = 0;
            while (iterator.hasNext()) {
                long sum = iterator.next().get();
                totProd += sum;
                LOG.info("prod sum = {}", sum);
            }
            LOG.info("prod tot = {}", totProd);
            long totCons = executor.submit(new BlockingConsumer(list)).get();
            LOG.info("cons tot = {}", totCons);
            LOG.info("total time = {}ms", System.currentTimeMillis() - start);
        } finally {
            // Executor shutdown
        }
    }
}

class BlockingProducer implements Callable<Long> {

    private final BlockingQueue<Integer> queue;
    private final int maxRange;

    public BlockingProducer(BlockingQueue<Integer> queue, int max) {
        this.queue = queue;
        this.maxRange = max;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = 1; i <= maxRange; i++) {
            sum += i;
            queue.add(i);
        }
        return sum;
    }
}

class BlockingConsumer implements Callable<Long> {

    private final BlockingQueue<Integer> queue;

    public BlockingConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.take();
        }
        return sum;
    }
}
