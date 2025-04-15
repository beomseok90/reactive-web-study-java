package com.beom.reactive.section6;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

/**
 * Subscriber가 처리 가능한 만큼의 request 갯수를 조절하는 Backpressure 예제
 */
@Slf4j
public class BackpressureExample02 {
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 5)
            .doOnNext(value -> log.info("[publisher]doOnNext: {}", value))
            .doOnRequest(value -> log.info("[publisher]doOnRequest: {}", value))
            .subscribe(new BaseSubscriber<Integer>() {
                @Override
                protected void hookOnSubscribe(Subscription subscription) {
                    request(2);
                }

                @Override
                protected void hookOnNext(Integer value) {
                    count++;
                    log.info("[subscriber] doOnNext: {}", value);
                    if (count == 2) {
                        try {
                            Thread.sleep(2000L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        request(2);
                        count = 0;
                    }
                }
            });
    }
}