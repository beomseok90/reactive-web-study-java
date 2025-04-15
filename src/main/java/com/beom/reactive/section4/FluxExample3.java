package com.beom.reactive.section4;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class FluxExample3 {
    public static void main(String[] args) {
        Flux<Object> flux =
                Mono.justOrEmpty(null)
                        .concatWith(Mono.justOrEmpty("Jobs"));
        flux.subscribe(data -> log.info("# result: {}", data));
    }
}
