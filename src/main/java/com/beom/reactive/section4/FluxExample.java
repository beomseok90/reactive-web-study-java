package com.beom.reactive.section4;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxExample {
    public static void main(String[] args) {
        Flux.just(6, 9, 13)
            .map(num -> num % 2)
            .subscribe(remainder -> log.info("# remainder: {}", remainder));
    }
}
