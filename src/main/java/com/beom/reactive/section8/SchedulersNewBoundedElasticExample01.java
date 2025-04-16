package com.beom.reactive.section8;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * Schedulers.newBoundedElastic()을 적용
 */
@Slf4j
public class SchedulersNewBoundedElasticExample01 {
    public static void main(String[] args) throws InterruptedException {
        Scheduler scheduler = Schedulers.newBoundedElastic(2, 2, "I/O-Thread");
        Mono<Integer> mono =
                    Mono
                        .just(1)
                        .subscribeOn(scheduler);

        log.info("# Start");

        mono.subscribe(data -> {
            log.info("subscribe 1 doing: {}", data);
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("subscribe 1 done: {}", data);
        });

        mono.subscribe(data -> {
            log.info("subscribe 2 doing: {}", data);
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("subscribe 2 done: {}", data);
        });

        mono.subscribe(data -> {
            log.info("subscribe 3 doing: {}", data);
        });

        mono.subscribe(data -> {
            log.info("subscribe 4 doing: {}", data);
        });

        mono.subscribe(data -> {
            log.info("subscribe 5 doing: {}", data);
        });

        mono.subscribe(data -> {
            log.info("subscribe 6 doing: {}", data);
        });

//        Thread.sleep(4000L);
//        scheduler.dispose();
    }
}