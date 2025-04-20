package com.beom.reactive.section11;

import reactor.core.publisher.Mono;

public class ContextExample {
    public static Mono<String> helloMessage(Mono<String> source, String key) {
        return source
                .zipWith(Mono.deferContextual(ctx -> Mono.just(ctx.get(key))))
                .map(tuple -> tuple.getT1() + ", " + tuple.getT2());

    }
}