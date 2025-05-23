package com.beom.reactive.section7;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import static reactor.core.publisher.Sinks.EmitFailureHandler.FAIL_FAST;

/**
 * Sinks.Many 예제
 *  - multicast()를 사용해서 하나 이상의 Subscriber에게 데이터를 emit하는 예제
 */
@Slf4j
public class SinkManyMulticastExample {
    public static void main(String[] args) {
        // 하나 이상의 Subscriber에게 데이터를 emit할 수 있다.
        Sinks.Many<Integer> multicastSink = Sinks.many().multicast().onBackpressureBuffer();
        Flux<Integer> fluxView = multicastSink.asFlux();

        multicastSink.emitNext(1, FAIL_FAST);
        multicastSink.emitNext(2, FAIL_FAST);


        fluxView.subscribe(data -> log.info("Subscriber1: {}", data));

        fluxView.subscribe(data -> log.info("Subscriber1: {}", data));

        multicastSink.emitNext(3, FAIL_FAST);
    }
}