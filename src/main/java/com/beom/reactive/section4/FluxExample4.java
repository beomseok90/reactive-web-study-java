package com.beom.reactive.section4;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class FluxExample4 {
    public static void main(String[] args) {
        Flux.concat(
                    Flux.just("Venus"),
                    Flux.just("Earth"),
                    Flux.just("Mars"))
            .collectList()
            .subscribe(planetList -> log.info("# Solar System: {}", planetList));
    }
}
