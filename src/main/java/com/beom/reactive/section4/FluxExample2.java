package com.beom.reactive.section4;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxExample2 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{3, 6, 7, 9})
            .filter(num -> num > 6)
            .map(num -> num * 2)
            .subscribe(multiply -> log.info("# multiply: {}", multiply));
    }
}
